package com.dateTimeInJava;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class ZoneDate {
    public static void main(String[] args) {
        for (String zoneId : ZoneId.getAvailableZoneIds()) {
            ZoneId zoneId1 = ZoneId.of(zoneId);
            String zoneIdDisplayNane = zoneId1.getDisplayName(TextStyle.FULL, Locale.US);
            System.out.println(zoneId + " : " + zoneIdDisplayNane);
        }

        ZoneId zoneId = ZoneId.of("US/Pacific");
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.of(ldt, zoneId);
        System.out.println(zdt);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("My zone is: " + zonedDateTime.getZone());
        System.out.println("My zone date time is: " + zonedDateTime);
    }
}
