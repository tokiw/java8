package ex06_08;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
	public static long parallelSort(BigInteger[] values) {
		System.out.print("parallelSort: ");
		Instant start = Instant.now();
		Arrays.parallelSort(values, (first, second) -> second.compareTo(first));
		Instant end = Instant.now();

		return Duration.between(start, end).toMillis();
	}
	
	public static long sort(BigInteger[] values) {
		System.out.print("sort:         ");
		Instant start = Instant.now();
		Arrays.sort(values, (first, second) -> second.compareTo(first));
		Instant end = Instant.now();
		
		return Duration.between(start, end).toMillis();
	}
	
	private static BigInteger[] createArray(int size) {
		return Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(size).toArray(value -> {
			return new BigInteger[value];
		});
	}
	
	public static void main(String[] args) {
		System.out.println("10000個");
		System.out.println(sort(createArray(10000)));
		System.out.println(parallelSort(createArray(10000)));
		
		System.out.println("100000個");
		System.out.println(sort(createArray(100000)));
		System.out.println(parallelSort(createArray(100000)));
		
		System.out.println("1000000個");
		System.out.println(sort(createArray(1000000)));
		System.out.println(parallelSort(createArray(1000000)));
		
		System.out.println("10000000個");
		System.out.println(sort(createArray(10000000)));
		System.out.println(parallelSort(createArray(10000000)));
	}
}
