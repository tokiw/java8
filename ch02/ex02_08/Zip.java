package ex02_08;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Zip {
	
	public static void main(String[] args) {
		Stream<String> first = Stream.of("a", "b", "c", "d", "e");
		Stream<String> second = Stream.of("aaa", "bbb", "ccc");
		zip(first, second).forEach(System.out::println);
	}
	
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		ZipSupplier<T> zip = new ZipSupplier<T>(first, second);
		return Stream.generate(zip).filter(s -> s != null);
	}
	
	static class ZipSupplier<T> implements Supplier<T> {
		private Iterator<T> first;
		private Iterator<T>second;
		private boolean isCurrentFirst = true;
		
		public ZipSupplier(Stream<T> first, Stream<T> second) {
			this.first = first.iterator();
			this.second = second.iterator();
		}
		@Override
		public T get() {
			if (hasNext()) {
				return next();
			} else {
				return null;
			}
		}
		
		private T next() {
			if (isCurrentFirst) {
				isCurrentFirst = !isCurrentFirst;
				return first.next();
			} else {
				isCurrentFirst = !isCurrentFirst;
				return second.next();
			}
		}
		
		private boolean hasNext() {
			if (isCurrentFirst) {
				return first.hasNext();
			} else {
				return second.hasNext();
			}
		}
	}
}
