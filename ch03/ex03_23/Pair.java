package ex03_23;

import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.function.Function;

public class Pair<T> {

	public static void main(String[] args) {
		Pair<String> pair = new Pair<>("key", "value");
		Entry<String, String> mappedEntry = pair.map(String::toUpperCase).getEntry();
		System.out.println(mappedEntry.getKey() + ": " + mappedEntry.getValue());
	}
	
	private AbstractMap.SimpleEntry<T, T> entry;
	
	public Pair(T key, T value) {
		entry = new AbstractMap.SimpleEntry<>(key, value);
	}
	
	public <U> Pair<U> map(Function<T, U> f) {
		return new Pair<>(f.apply(entry.getKey()), f.apply(entry.getValue()));
	}
	
	public Entry<T, T> getEntry() {
		return entry;
	}
}
