package ex02_07;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		System.out.println(isFinite(Stream.of("one", "two", "three", "four", "five")));
		
		System.out.println(isFinite(Stream.generate(() -> "infinity")));
	}

	// streamが有限であるか??(無限ストリームであるか)
	// あると割りと便利だと思うが、streamを作った人が作る段階ですでに無限化知っているはず??
	public static <T> boolean isFinite(Stream<T> stream) {
		return stream.spliterator().getExactSizeIfKnown() != -1;
	}
}
