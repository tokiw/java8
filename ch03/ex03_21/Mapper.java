package ex03_21;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mapper {
	
	public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
		return list.stream().map(f::apply).collect(Collectors.toList());
	}
	
	public static <T, U> Future<U> map(Future<T> future, Function<T, U> f) {
		return new Future<U>() {

			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return future.cancel(mayInterruptIfRunning);
			}

			@Override
			public boolean isCancelled() {
				return future.isCancelled();
			}

			@Override
			public boolean isDone() {
				return future.isDone();
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				return f.apply(future.get());
			}

			@Override
			public U get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
				return f.apply(future.get(timeout, unit));
			}
		};
	}
}