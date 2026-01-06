package com.dateTimeInJava.period;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodExample {
    public static void main(String[] args) {
        Period p1 = Period.of(1, 1, 1);
        System.out.println(p1);

        Period p2 = Period.ofDays(100);
        System.out.println(p2);

        // period between two dates:
        LocalDate localDate = LocalDate.of(2019, 12, 18);
        LocalDate localDate1 = LocalDate.now();
        Period period = Period.between(localDate, localDate1);
        System.out.println(period);

        // amount of days between two dates:
        long daysBetweenPeriod = ChronoUnit.DAYS.between(localDate, localDate1);
        System.out.println(daysBetweenPeriod);

        // addition and subtraction Period
        LocalDate today = LocalDate.now();
        LocalDate future = today.plus(Period.ofYears(2));
        LocalDate past = today.minus(Period.ofYears(1));
        System.out.println(future);
        System.out.println(past);

        // calculate person's age
        LocalDate birth = LocalDate.of(1978, 8, 8);
        LocalDate now = LocalDate.now();
        Period age = Period.between(birth, now);
        System.out.println(age.getYears() + age.getMonths() + age.getDays());
    }
}
