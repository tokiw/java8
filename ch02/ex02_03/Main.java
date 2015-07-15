package ex02_03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		long start;
		long end;
		long streamProcess;
		long parallelStreamProcess;
		
		try {
			String contents = new String(Files.readAllBytes(Paths.get("ch02/ex02_03/momotaro.txt")), StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("[¥¥P{L}]+"));
			System.out.println("stream");
			start = System.nanoTime();
			streamFilter(words);
			end = System.nanoTime();
			streamProcess = end - start;
			System.out.println(streamProcess + "ns");
			
			System.out.println();
			
			System.out.println("parallelStream");
			start = System.nanoTime();
			parallelStreamFilter(words);
			end = System.nanoTime();
			parallelStreamProcess = end - start;
			System.out.println(parallelStreamProcess + "ns");
			
			System.out.println("差は" + (streamProcess - parallelStreamProcess) + "ns");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	public static long streamFilter(List<String> words) {
		return words.stream().filter(w-> w.length() > 12).count();
	}
	
	public static long parallelStreamFilter(List<String> words) {
		return words.parallelStream().filter(w-> w.length() > 12).count();
	}
}
