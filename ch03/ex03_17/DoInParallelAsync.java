package ex03_17;

import java.util.function.Consumer;

public class DoInParallelAsync {
	
	public static void main(String[] args) {
		DoInParallelAsync.doInParallelAsync(() -> {
			throw new NullPointerException();
		}, () -> {
			
		}, e -> {
			e.printStackTrace();
		});
		
		DoInParallelAsync.doInParallelAsync(() -> {
			
		}, () -> {
			throw new NullPointerException();
		}, e -> {
			e.printStackTrace();
		});
	}
	
	public static <T> void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		new Thread(() -> {
			try {
				first.run();
			} catch (Exception e) {
				handler.accept(e);
			}
		});
		new Thread(() -> {
			try {
				second.run();
			} catch (Exception e) {
				handler.accept(e);
			}
		});
	}
}
