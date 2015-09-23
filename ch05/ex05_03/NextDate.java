package ex05_03;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class NextDate {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today.with(next(w -> w.getDayOfWeek().getValue() < 6)));
	}
	
	public static TemporalAdjuster next(Predicate<LocalDate> condition) {
		return TemporalAdjusters.ofDateAdjuster(w -> {
			LocalDate result = w;
			do {
				result = result.plusDays(1);
			} while (!condition.test(result));
			return result;
		});
	}
}
