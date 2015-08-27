package ex02_08;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Zip {
	
	public static void main(String[] args) {
		Stream<String> first = Stream.of("a", "b", "c", "d", "e", "f");
		Stream<String> second = Stream.of("aaa", "bbb", "ccc");
		zip(first, second).forEach(System.out::println);
	}
	
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		ZipSupplier<T> zip = new ZipSupplier<T>(first, second);
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(zip, Spliterator.NONNULL), false);
	}
	
	static class ZipSupplier<T> implements Iterator<T> {
		private Iterator<T> first;
		private Iterator<T>second;
		private boolean isCurrentFirst = true;
		
		public ZipSupplier(Stream<T> first, Stream<T> second) {
			this.first = first.iterator();
			this.second = second.iterator();
		}
		
		@Override
		public T next() {
			if (isCurrentFirst || !second.hasNext()) {
				isCurrentFirst = !isCurrentFirst;
				if (first.hasNext()) {
					return first.next();
				}
			}
			isCurrentFirst = !isCurrentFirst;
			if (second.hasNext()) {
				return second.next();
			}
			return null;
		}
		
		@Override
		public boolean hasNext() {
			return first.hasNext() || second.hasNext();
		}
	}
}
