package ex06_03;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Supplier;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("AtomicLong:  " + getAverage(() -> {
			return measureAtomicLong(1000, 100000).toNanos();
		}) + "ns");
		System.out.println("AtomicAdder: " + getAverage(() -> {
			return measureLongAdder(1000, 100000).toNanos();
		}) + "ns");
	}
	
	private static long getAverage(Supplier<Long> supplier) {
		LongAdder longAdder = new LongAdder();
		int repeatCount = 5;
		for (int i = 0; i < repeatCount; i++) {
			longAdder.add(supplier.get());
		}
		return longAdder.sum() / repeatCount;
	}
	
	public static Duration measureAtomicLong(int threadSize, int repeatCount) {
		CountDownLatch countDownLatch = new CountDownLatch(repeatCount);
		ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);
		AtomicLong atomicLong = new AtomicLong(0);
		Instant start = Instant.now(); 
		for (int i = 0; i < repeatCount; i++) {
			threadPool.submit(()-> {
				atomicLong.incrementAndGet();
				countDownLatch.countDown();
			});
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			threadPool.shutdown();
		}
		Instant end = Instant.now();
		return Duration.between(start, end);
	}
	
	
	public static Duration measureLongAdder(int threadSize, int repeatCount) {
		CountDownLatch countDownLatch = new CountDownLatch(repeatCount);
		ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);
		LongAdder longAdder = new LongAdder();
		Instant start = Instant.now(); 
		for (int i = 0; i < repeatCount; i++) {
			threadPool.submit(()-> {
				longAdder.increment();
				countDownLatch.countDown();
			});
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			threadPool.shutdown();
		}
		Instant end = Instant.now();
		return Duration.between(start, end);
	}
}
