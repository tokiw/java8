package ex06_04;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		List<Long> longs = Arrays.asList(0L, 100L, -100L, 1000L, -1000L);
		System.out.println(getMax(longs.stream()));
		System.out.println(getMin(longs.stream()));
	}
	
	public static long getMax(Stream<Long> longStream) {
		LongAccumulator longAccumulator = new LongAccumulator(Long::max, Long.MIN_VALUE);
		longStream.parallel().forEach(longAccumulator::accumulate);
		return longAccumulator.get();
	}
	
	public static long getMin(Stream<Long> longStream) {
	LongAccumulator longAccumulator = new LongAccumulator(Long::min, Long.MAX_VALUE);
	longStream.parallel().forEach(longAccumulator::accumulate);
	return longAccumulator.get();
	}
}
