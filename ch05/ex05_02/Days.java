package ex05_02;

import java.time.LocalDate;

public class Days {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2000, 2, 29);
		System.out.println("Base              :" + date.toString());
		System.out.println("Add 1 Year        :" + Days.addOneYear(date).toString());
		System.out.println("Add 4 Year        :" + Days.addFourYear(date).toString());
		System.out.println("Add 1 Year 4 times:" + Days.addFourYearByLoop(date).toString());
	}
	
	public static LocalDate addOneYear(LocalDate date) {
		return date.plusYears(1);
	}
	
	public static LocalDate addFourYear(LocalDate date) {
		return date.plusYears(4);
	}
	
	public static LocalDate addFourYearByLoop(LocalDate date) {
		return date.plusYears(1)
				  .plusYears(1)
				  .plusYears(1)
				  .plusYears(1);
	}
}
