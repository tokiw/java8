package ex06_11;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
		return CompletableFuture.supplyAsync(action).thenComposeAsync(t -> {
			if (until.test(t)) {
				return CompletableFuture.completedFuture(t);
			} else {
				return repeat(action, until);
			}
		});
	}
	
	public static void main(String[] args) {
		
	}
}
