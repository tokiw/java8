package ex05_04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Cal {
	public static void main(String[] args) {
        int month = Integer.valueOf(args[0]);
        int year = Integer.valueOf(args[1]);

        show(year, month);
    }

    private static void show(final int year, final int month){
        if (year <= 0) {
            throw new IllegalArgumentException();
        }
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException();
        }
        Month m = Month.of(month);
        LocalDate firstDay = LocalDate.of(year, m, 1);
        LocalDate lastDay = firstDay.with(TemporalAdjusters.lastDayOfMonth());

        String padding = "  ";
        String space = " ";

        // 初日までを埋める
        for (int i = 0; i < firstDay.getDayOfWeek().getValue()-1; i++) {
            System.out.print(padding + space);
        }

        LocalDate day = firstDay;
        while (!day.isAfter(lastDay)) {
            if (day.getDayOfMonth() < 10) {
                System.out.print(" " + day.getDayOfMonth() + space);
            } else {
                System.out.print(day.getDayOfMonth() + space);
            }
            if (day.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println("");
            }
            day = day.plusDays(1);
        }
    }
}
