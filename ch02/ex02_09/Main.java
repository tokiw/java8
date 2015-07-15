package ex02_09;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream<ArrayList<String>> arrayListStream = createStreamData();
		ArrayList<String> arrayList = arrayListStream.reduce(new ArrayList<>(),
			(l, r) -> {
				l.addAll(r);
				return l;
			},
			(l, r) -> {
				l.addAll(r);
				return l;
			}
		);
		arrayList.stream().forEach(System.out::println);
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
