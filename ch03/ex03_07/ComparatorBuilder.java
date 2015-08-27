package ex03_07;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorBuilder {
	
	public static void main(String[] args) {
		String[] array = {"a", "C", " b", "e", "　d"};
		Arrays.sort(array, ComparatorBuilder.stringComparatorGenerator(true, false, false));
		for (String str : array) {
			System.out.println(str);
		}
	}
	
	public static Comparator<String> stringComparatorGenerator(boolean isAscending, boolean caseSensitive, boolean includeBlank) {
		return (first, second) -> {
			if (!isAscending) {
				String tmp = second;
				second = first;
				first = tmp;
			}
			if (!includeBlank) {
				first = trim(first);
				second = trim(second);
			}
			if (caseSensitive) {
				return first.compareTo(second);
			} else {
				return first.compareToIgnoreCase(second);
			}
		};
	}
	
	private static String trim(String str) {
		return str.replaceAll(" ", "").replaceAll("　", "");
	}
}
