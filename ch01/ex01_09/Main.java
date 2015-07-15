package ex01_09;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		Collection2<File> collection = new ArrayList2<File>();
		collection.add(new File("/Users/masafumi/Documents/workspace/java8_practice"));
		collection.add(new File("/Users/masafumi/Documents/workspace/java8_practice/ch01/ex01_03/Main.java"));
		collection.add(new File("test.txt"));
		collection.add(new File("/Users/masafumi/Documents/workspace/java8_practice/ch01/ex01_03"));
		
		collection.forEachIf(System.out::println, File::isDirectory);
	}
}
