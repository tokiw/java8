package ex01_04;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File[] files = {
				new File("/Users/masafumi/Documents/workspace/java8_practice"),
				new File("/Users/masafumi/Documents/workspace/java8_practice/ch01/ex01_03/Main.java"),
				new File("test.txt"),
				new File("/Users/masafumi/Documents/workspace/java8_practice/ch01/ex01_03")
		};
		
		System.out.println("ソート前");
		
		for (File file : files) {
			System.out.println(file.getName() + ": " + file.getAbsolutePath());
		}
		
		files = FileSorter.sort(files);
		
		System.out.println("ソート後");
		
		for (File file : files) {
			System.out.println(file.getName() + ": " + file.getAbsolutePath());
		}
	}
}
