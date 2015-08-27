package ex03_02;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class WithLock {
	
	/**
	 * 
	 * @param lock
	 * @param run
	 * @throws NullPointerException if arguments are null
	 */
	public static void withLock(ReentrantLock lock, Runnable run) throws NullPointerException {
		Objects.requireNonNull(lock);
		Objects.requireNonNull(run);
		lock.lock();
		try {
			run.run();
		} finally {
			lock.unlock();
		}
	}
}
