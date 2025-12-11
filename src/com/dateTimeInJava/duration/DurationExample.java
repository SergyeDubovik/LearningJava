package com.dateTimeInJava.duration;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationExample {
    public static void main(String[] args) {
        Duration duration = Duration.of(1, ChronoUnit.DAYS);
        System.out.println(duration);

        Duration duration1 = Duration.ofHours(5);
        System.out.println(duration1);

        // duration between two dates below,
        LocalTime localTime1 = LocalTime.of(23, 34);
        LocalTime localTime = LocalTime.now();
        Duration duration2 = Duration.between(localTime, localTime1);
        System.out.println(duration2);

        // show duration only in hours
        System.out.println(duration2.toHours());
        // show duration only in minutes
        System.out.println(duration2.toMinutes());
    }

}
