package ex02_04;

import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};
		IntStream stream = IntStream.of(values);
		stream.forEach(System.out::println);
	}

}
