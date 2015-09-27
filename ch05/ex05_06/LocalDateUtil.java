package ex05_06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class LocalDateUtil {
	
	public static void main(String[] args) {
		List<LocalDate> fridaysIn20Century = LocalDateUtil.getDays(20, 13, DayOfWeek.FRIDAY);
		for (LocalDate friday : fridaysIn20Century) {
			System.out.println(friday.toString() + ": " + friday.getDayOfWeek().toString());
		}
	}
	
	/**
	 * 
	 * @param century
	 * @param dayOfMonth
	 * @param weekDay
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static List<LocalDate> getDays(int century, int dayOfMonth, DayOfWeek weekDay) throws IllegalArgumentException {
		if (dayOfMonth <= 0) {
			throw new IllegalArgumentException();
		}
		List<LocalDate> days = new ArrayList<LocalDate>();
		final LocalDate firstDay = LocalDate.of((century-1)*100+1, 1, 1);
		final LocalDate firstDayNextCentury = LocalDate.of(century*100+1, 1, 1);
		LocalDate tmpDay = firstDay;
		boolean isEnd = false;
		TemporalAdjuster NEXT_FRIDAY_IN_20_CENTURY = buildTemporalAdjuster(dayOfMonth, weekDay);
		
		while(!isEnd) {
			tmpDay = tmpDay.with(NEXT_FRIDAY_IN_20_CENTURY);
			if (tmpDay.isBefore(firstDayNextCentury)) {
				days.add(tmpDay);
			} else {
				isEnd = true;
			}
		}
		
		return days;
	}
	
	private static TemporalAdjuster buildTemporalAdjuster(int dayOfMonth, DayOfWeek weekDay) {
		return TemporalAdjusters.ofDateAdjuster(w -> {
			LocalDate result = w;
			do {
				result = result.with(TemporalAdjusters.next(weekDay));
			} while (result.getDayOfMonth() != dayOfMonth);
			return result;
		});
	}
}
