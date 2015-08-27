package ex03_16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class DoInOrderAsync {
	public static void main(String[] args) {
		String number = "a";
		DoInOrderAsync.doInOrderAsync(() -> {
			return Double.valueOf(number);
		}, (s, t) -> {
			if (t == null) {
				System.out.println(s);
			} else {
				t.printStackTrace();
			}
		});
	}
	
	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
		Thread t = new Thread() {
			public void run() {
				try {
					T result = first.get();
					second.accept(result, null);
				} catch (Throwable e) {
					second.accept(null, e);
				}
			}
		};
		t.start();
	}
}
