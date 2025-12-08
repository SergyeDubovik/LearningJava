package com.dateTimeInJava.scheduleAssistant;

import java.time.LocalTime;

public class Developer {
    final String name;
    final String city;
    final LocalTime workDayStartTime;

    public Developer(final String name, final String city, final LocalTime workDayStartTime) {
        this.name = name;
        this.city = city;
        this.workDayStartTime = workDayStartTime;
    }

//    public boolean isFree(LocalDateTime proposedTime) {
//        ZoneId zoneId = ZoneId.of(city);
//        Instant instant = proposedTime.atZone(ZoneId.of("UTC")).toInstant();
//        proposedTime =
//        if ()
//        return false;
//    }
}
