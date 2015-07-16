package ex01_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> copyFrom = Arrays.asList("aaa", "bbb", "ccc");
		List<String> copyTo = new ArrayList<>();
		copyTo.add("a");
		copyTo.add("b");
		copyTo.add("c");
		Collections.copy(copyTo, copyFrom);
		copyTo.forEach(System.out::println);
		
		List<String> copyFrom2 = Arrays.asList("ddd", "eee", "fff");
		// そんなにうれしくないな
		List2.copy(copyTo, copyFrom2);
		copyTo.forEach(System.out::println);
	}
}
