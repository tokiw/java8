package ex01_06;

import java.util.concurrent.Callable;

public class Unchecker {
	
	@FunctionalInterface
	public interface RunnableEx {
		void run() throws Exception;
	}
	
	public static Runnable uncheck(RunnableEx runnable) {
		return () -> {
			try {
				runnable.run();
			} catch(Exception e) {
				throw new RuntimeException();
			}
		};
	}

	// 動いた...
	// uncheck( () -> {})と書くとどちらが使われる??
	public static Runnable uncheck(Callable<Void> callable) {
		return () -> {
			try {
				callable.call();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		};
	}
}
