package ex02_02;

import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Stream<String> words = Stream.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
		long count = words.filter(w -> { 
			System.out.println(w);
			return w.length() > 5;
		})
		.limit(5)
		.count();
		
		System.out.println("Count: " + count);
	}
}
