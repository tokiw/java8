package ex02_13;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelFilter {

	public static void main(String[] args) {
		int[] results = countFilterString(Stream.of("a", "bb", "cc", "ddd", "fff", "eee", "fffffffffff"), 12);
		for (int result : results) {
			System.out.println(result);
		}
	}

	public static int[] countFilterString(Stream<String> stream, int hreshold) throws IllegalArgumentException {
		if (hreshold <= 0 || Objects.isNull(stream)) {
			throw new IllegalArgumentException();
		}
		Map<Integer, Long> counts = stream.parallel().filter(s -> s.length() < hreshold).collect(Collectors.groupingBy(String::length, Collectors.counting()));
		
		return IntStream.range(0, hreshold).map(i -> {
			Long count = counts.get(i);
			if (Objects.isNull(count)) {
				return 0;
			}
			return count.intValue();
		}).toArray();
	}
}
