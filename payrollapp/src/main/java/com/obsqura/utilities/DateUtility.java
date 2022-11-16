package com.obsqura.utilities;

import java.time.LocalDate;

public class DateUtility {
	public static void printCurrentDayMonthAndYear() {
	     LocalDate today = LocalDate.now();
	     int year = today.getYear();
	     int month = today.getMonthValue();
	     int day = today.getDayOfMonth();
	     System.out.println(day+"/"+month+"/"+year);
	 }
}
