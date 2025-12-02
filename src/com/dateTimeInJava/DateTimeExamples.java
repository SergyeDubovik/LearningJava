package com.dateTimeInJava;

import java.time.*;

public class DateTimeExamples {
    public static void main(String[] args) {
        // date
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2008, 5, 23);
        LocalDate localDate2 = LocalDate.of(2008, Month.APRIL, 23);

        System.out.println(localDate);
        System.out.println(localDate1);
        System.out.println(localDate2);

//        invalidDate
//        LocalDate invalidDate = LocalDate.of(2023, 13, 24);
//        System.out.println(invalidDate);

        // time
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(23, 21, 43);

        System.out.println(localTime);
        System.out.println(localTime1);

        // dateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 2, 21, 12, 45);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        // monthDay
        MonthDay monthDay = MonthDay.now();
        MonthDay monthDay1 = MonthDay.of(6, 12);
        LocalDate newLocalDate = monthDay1.atYear(2023);

        System.out.println(monthDay);
        System.out.println(newLocalDate);

        //yearMonth
        YearMonth yearMonth = YearMonth.now();
        LocalDate yearMonthLocalDate = yearMonth.atDay(7);

        System.out.println(yearMonth);
        System.out.println(yearMonthLocalDate);


    }
}
