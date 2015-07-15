package ex01_02;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		System.out.println("#ラムダ式");
		File[] files = Directory.getSubDirectory("/Users/masafumi/Documents/workspace/java8_practice");
		for(File file : files) {
			System.out.println(file.getName());
		}
		
		System.out.println("メソッド参照");
		File[] files2 = Directory.getSubDirectory2("/Users/masafumi/Documents/workspace/java8_practice");
		for(File file : files2) {
			System.out.println(file.getName());
		}
	}

}
