package ex02_04;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};
		Stream<int[]> stream = Stream.of(values);
		System.out.println(stream.findFirst().toString());
	}

}
