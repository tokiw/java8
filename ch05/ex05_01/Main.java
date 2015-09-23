package ex05_01;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class Main {
	public static void main(String[] args) {
		System.out.println(getProgrammersDay1().toString());
		System.out.println(getProgrammersDay2().toString());
		System.out.println(getPragrammersDay3().toString());
	}
	
	public static LocalDate getProgrammersDay1() {
		return LocalDate.of(2015, 1, 1).plus(Period.ofDays(255));
	}
	
	public static LocalDate getProgrammersDay2() {
		int year = LocalDate.now().getYear();
		return LocalDate.ofYearDay(year, 256);
	}
	
	public static LocalDate getPragrammersDay3() {
		return Year.now().atDay(256);
	}
}
