package ex01_03;

public class Main {

	public static void main(String[] args) {
		String[] filenames = Directory.getAllSubFiles("/Users/masafumi/Documents/workspace/java8/ch01/ex01_03", "java");
		for (String filename : filenames) {
			System.out.println(filename);
		}
	}

}
