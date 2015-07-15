package ex02_10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class MathStream {
	public static double averageDouble(Stream<Double> streamDouble) {
		AtomicInteger count = new AtomicInteger();
		double sum = streamDouble.peek(d -> count.getAndIncrement()).reduce(0.0, Double::sum);
		if (count.get() == 0) {
			return 0;
		}
		return sum / count.get();
	}
	
	// これでもいける??
	public static double averageDouble2(Stream<Double> streamDouble) {
		// スレッドセーフではない
		Double[] sum = {0.0};
		long count = streamDouble.peek(d -> { sum[0] += d; }).count();
		if (count == 0) {
			return 0;
		}
		return sum[0] / count;
	}
	
	public static void main(String[] args) {
		System.out.println(averageDouble(Stream.of(0.0, 1.0, 2.0, 3.0, 4.0)));
		System.out.println(averageDouble2(Stream.of(0.0, 1.0, 2.0, 3.0, 4.0)));
		
		System.out.println(averageDouble(Stream.of()));
		System.out.println(averageDouble2(Stream.of()));
		
		// 単純に合計を計算してcount()で割るとcount()が0のときにNoNになるからダメ??
	}
}
