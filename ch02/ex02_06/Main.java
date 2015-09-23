package ex02_06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream<Character> stream = characterStream("asdfghjkl");
		stream.forEach(System.out::print);
		
		System.out.println();
		
		Stream<Character> stream2 = characterStream2("asdfghjkl");
		stream2.forEach(System.out::print);
	}
	
	public static Stream<Character> characterStream(String s) {
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray()) {
			result.add(c);
		}
		return result.stream();
	}
	
	public static Stream<Character> characterStream2(String s) {
		return IntStream.range(0, s.length()).mapToObj(s::charAt);
	}
}
