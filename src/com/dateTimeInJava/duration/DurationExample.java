package com.dateTimeInJava.duration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationExample {
    public static void main(String[] args) {
        Duration duration = Duration.of(1, ChronoUnit.DAYS);
        System.out.println(duration);

        Duration duration1 = Duration.ofHours(5);
        System.out.println(duration1);

        // duration between two dates below,
        LocalTime localTime1 = LocalTime.of(23, 55);
        LocalTime localTime = LocalTime.now();
        Duration duration2 = Duration.between(localTime, localTime1);
        System.out.println(duration2);

        // show duration only in hours
        System.out.println(duration2.toHours());
        // show duration only in minutes
        System.out.println(duration2.toMinutes());

        LocalDateTime lcd = LocalDateTime.of(2021, 12, 23, 0, 25);
        LocalDateTime lcd1 = LocalDateTime.now();
        Duration duration3 = Duration.between(lcd, lcd1);
        System.out.println(duration3.toDays());

        long days = ChronoUnit.DAYS.between(lcd, lcd1);
        System.out.println(days);

        // important:
        // Duration / ChronoUnit.DAYS с LocalDateTime count the number of full days (24 hours)
        // To calculate calendar days (date changes), you need to use LocalDate
        LocalDateTime a = LocalDateTime.of(2021, 12, 23, 23, 59);
        LocalDateTime b = LocalDateTime.of(2021, 12, 24, 0, 1);
        Duration duration4 = Duration.between(a, b);
        System.out.println(duration4.toDays()); // 0
        System.out.println(ChronoUnit.DAYS.between(a, b)); // 0
        System.out.println(ChronoUnit.DAYS.between(a.toLocalDate(), b.toLocalDate())); // 1

        // calculate how to apply 'Duration' for future and past dates
        LocalDateTime now = LocalDateTime.now();
        Duration twoDays = Duration.ofDays(2);

        LocalDateTime future = now.plus(twoDays);
        LocalDateTime past = now.minus(twoDays);

        System.out.println("Now: " + now);
        System.out.println("Future: " + future);
        System.out.println("Past: " + past);
    }

}
