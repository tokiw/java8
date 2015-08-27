package ex03_20;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mapper {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Mapper.map(list, u -> {
			return u*u;
		}).forEach(System.out::println);
	}
	
	
	public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
		return list.stream().map(f::apply).collect(Collectors.toList());
	}
}
