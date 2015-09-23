package ex02_09;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> arrayList1 = reduce1(createStreamData());
		arrayList1.stream().forEach(System.out::println);
		
		ArrayList<String> arrayList2 = reduce2(createStreamData());
		arrayList2.stream().forEach(System.out::println);
		
		ArrayList<String> arrayList3 = reduce3(createStreamData());
		arrayList3.stream().forEach(System.out::println);
	}
	
	private static <T> ArrayList<T> reduce3(Stream<ArrayList<T>> stream) {
		return stream.reduce(new ArrayList<>(),
			(l, r) -> {
				l.addAll(r);
				return l;
			},
			(l, r) -> {
				l.addAll(r);
				return l;
			}
		);
	}
	
	private static <T> ArrayList<T> reduce2(Stream<ArrayList<T>> stream) {
		return stream.reduce(new ArrayList<>(),
			(l, r) -> {
				l.addAll(r);
				return l;
			}
		);
	}
	
	private static <T> ArrayList<T> reduce1(Stream<ArrayList<T>> stream) {
		return stream.reduce((l, r) -> {
			l.addAll(r);
			return l;
		}).orElse(new ArrayList<>());
	}
	
	private static Stream<ArrayList<String>> createStreamData() {
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("aa");
		list2.add("bb");
		list2.add("cc");
		list2.add("dd");
		
		ArrayList<String> list3 = new ArrayList<>();
		list3.add("aaa");
		list3.add("bbb");
		list3.add("ccc");
		list3.add("ddd");
		list3.add("eee");
		
		return Stream.of(list1, list2, list3);
	}
}
