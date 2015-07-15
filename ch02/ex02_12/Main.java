package ex02_12;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		AtomicInteger[] counts = new AtomicInteger[3];
		for (int i=0; i<3;i++) {
			counts[i] = new AtomicInteger();
		}
		
		Stream<String> stream = Stream.of("", "a", "b", "cc", "dd", "ee");
		
		stream.parallel().forEach(s -> {
			if ( s.length() < 3) {
				counts[s.length()].getAndIncrement();
			}
		});

		Arrays.asList(counts).stream().forEach(count -> System.out.println(count.get()));
	}

}
