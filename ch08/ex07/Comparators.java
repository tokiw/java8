package ex07;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.*;

public class Comparators {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("b", "a", null, "c");
		Collections.sort(list, nullsLast(Collections.reverseOrder()));
		list.forEach(System.out::println);
	}
}
