package ex10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ZipWalker {
	public static void main(String[] args) {
		try {
			unzip(Paths.get("/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/src.zip")).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Stream<Path> unzip(Path path) throws IOException {
		return Files.walk(path).filter(p -> p.toFile().isFile()).filter(p -> {
			try {
				return Files.readAllLines(p).stream().allMatch( w -> w.contains("transient") || w.contains("volatile"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		});
	}
}
