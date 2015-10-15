package ex06_05;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class WordMap {
	
	public static Map<String, Set<File>> load(Set<File> files) {
		Objects.requireNonNull(files);
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		ConcurrentHashMap<String, Set<File>> result = new ConcurrentHashMap<String, Set<File>>();
		
		files.forEach(file -> pool.submit(() -> {
			String contents;
			try {
				contents = new String(Files.readAllBytes(file.toPath() ), StandardCharsets.UTF_8);
				Stream.of(contents.split("[\\P{L}]+")).forEach(content -> {
					result.merge(content, Collections.singleton(file), (existingValue, newValue) -> {
						Set<File> r = new HashSet<File>(existingValue);
						r.addAll(newValue);
						return r;
					});
				});
			} catch (Exception e) {
				e.printStackTrace();
				throw new IllegalArgumentException("file cound not open");
			}
		}));
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.HOURS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Set<File> fileSet = new HashSet<File>();
		fileSet.add(Paths.get("ch06/ex06_05/file1.txt").toFile());
		fileSet.add(Paths.get("ch06/ex06_05/file2.txt").toFile());
		fileSet.add(Paths.get("ch06/ex06_05/file3.txt").toFile());
		Map<String, Set<File>> result = load(fileSet);
		result.forEach((word, files) -> {
			System.out.print(word + ": ");
			files.forEach(file -> {
				System.out.print(file.getName() + " ");
			});
			System.out.println();
		});
	}
}
