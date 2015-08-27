package ex03_18;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Unchecker {
	
	public static <T> Supplier<T> unchecked(Callable<T> f) {
		return () -> {
			try {
				return f.call();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} catch (Throwable e) {
				throw e; 
			}
		};
	}
	
	public static <T, U> Function<T, U> unchecked(UncheckFunction<T, U> f) {
		return u -> {
			try {
				return f.apply(u);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} catch (Throwable e) {
				throw e; 
			}
		};
	}
	
	@FunctionalInterface
	public interface UncheckFunction<T, U> {
		U apply(T t) throws Exception;
	}
}
