package com.dateTimeInJava.scheduleAssistant;

import java.time.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SchedulingAssistantImpl implements SchedulingAssistant {

    private final Collection<Developer> team;
    private final LocalDate today;
    private static final Map<String, String> CITY_TO_TIMEZONE = new HashMap<>();

    static {
        // common cities and their time zones
        CITY_TO_TIMEZONE.put("Los Angeles", "America/Los_Angeles");
        CITY_TO_TIMEZONE.put("New York", "America/New_York");
        CITY_TO_TIMEZONE.put("Chicago", "America/Chicago");
        CITY_TO_TIMEZONE.put("London", "Europe/London");
        CITY_TO_TIMEZONE.put("Paris", "Europe/Paris");
        CITY_TO_TIMEZONE.put("Berlin", "Europe/Berlin");
        CITY_TO_TIMEZONE.put("Prague", "Europe/Prague");
        CITY_TO_TIMEZONE.put("Moscow", "Europe/Moscow");
        CITY_TO_TIMEZONE.put("Samara", "Europe/Samara");
        CITY_TO_TIMEZONE.put("Tokyo", "Asia/Tokyo");
        CITY_TO_TIMEZONE.put("Sydney", "Australia/Sydney");
        CITY_TO_TIMEZONE.put("Dubai", "Asia/Dubai");
        CITY_TO_TIMEZONE.put("Singapore", "Asia/Singapore");
        CITY_TO_TIMEZONE.put("Hong Kong", "Asia/Hong_Kong");
        CITY_TO_TIMEZONE.put("Mumbai", "Asia/Kolkata");
        CITY_TO_TIMEZONE.put("Delhi", "Asia/Kolkata");
        CITY_TO_TIMEZONE.put("Shanghai", "Asia/Shanghai");
        CITY_TO_TIMEZONE.put("Beijing", "Asia/Shanghai");
        CITY_TO_TIMEZONE.put("Seoul", "Asia/Seoul");
        CITY_TO_TIMEZONE.put("Istanbul", "Europe/Istanbul");
        CITY_TO_TIMEZONE.put("Rome", "Europe/Rome");
        CITY_TO_TIMEZONE.put("Madrid", "Europe/Madrid");
        CITY_TO_TIMEZONE.put("Amsterdam", "Europe/Amsterdam");
        CITY_TO_TIMEZONE.put("Brussels", "Europe/Brussels");
        CITY_TO_TIMEZONE.put("Vienna", "Europe/Vienna");
        CITY_TO_TIMEZONE.put("Warsaw", "Europe/Warsaw");
        CITY_TO_TIMEZONE.put("Athens", "Europe/Athens");
        CITY_TO_TIMEZONE.put("Helsinki", "Europe/Helsinki");
        CITY_TO_TIMEZONE.put("Stockholm", "Europe/Stockholm");
        CITY_TO_TIMEZONE.put("Oslo", "Europe/Oslo");
        CITY_TO_TIMEZONE.put("Copenhagen", "Europe/Copenhagen");
        CITY_TO_TIMEZONE.put("Lisbon", "Europe/Lisbon");
        CITY_TO_TIMEZONE.put("Kyiv", "Europe/Kiev");
        CITY_TO_TIMEZONE.put("Kiev", "Europe/Kiev");
        CITY_TO_TIMEZONE.put("Bucharest", "Europe/Bucharest");
        CITY_TO_TIMEZONE.put("Sofia", "Europe/Sofia");
        CITY_TO_TIMEZONE.put("Tbilisi", "Asia/Tbilisi");
        CITY_TO_TIMEZONE.put("Yerevan", "Asia/Yerevan");
        CITY_TO_TIMEZONE.put("Baku", "Asia/Baku");
        CITY_TO_TIMEZONE.put("Tel Aviv", "Asia/Tel_Aviv");
        CITY_TO_TIMEZONE.put("Cairo", "Africa/Cairo");
        CITY_TO_TIMEZONE.put("Johannesburg", "Africa/Johannesburg");
        CITY_TO_TIMEZONE.put("Toronto", "America/Toronto");
        CITY_TO_TIMEZONE.put("Vancouver", "America/Vancouver");
        CITY_TO_TIMEZONE.put("Montreal", "America/Montreal");
        CITY_TO_TIMEZONE.put("Mexico City", "America/Mexico_City");
        CITY_TO_TIMEZONE.put("Sao Paulo", "America/Sao_Paulo");
        CITY_TO_TIMEZONE.put("Rio de Janeiro", "America/Sao_Paulo");
        CITY_TO_TIMEZONE.put("Buenos Aires", "America/Argentina/Buenos_Aires");
        CITY_TO_TIMEZONE.put("Lima", "America/Lima");
        CITY_TO_TIMEZONE.put("Bogota", "America/Bogota");
        CITY_TO_TIMEZONE.put("Santiago", "America/Santiago");
    }


    private SchedulingAssistantImpl(Collection<Developer> team, LocalDate today) {
        this.team = team;
        this.today = today;
    }

    public static SchedulingAssistant create(Collection<Developer> team, LocalDate today) {
        if (team == null || team.isEmpty() || today == null) {
            throw new IllegalArgumentException("Team must not be null or empty, and Today date must not be null.");
        }
        return new SchedulingAssistantImpl(team, today);
    }

    @Override
    public LocalDateTime schedule(long meetingDurationMinutes, MeetingTimingPreferences preferences) {
        LocalDate targetDate = getTargetDate(preferences.period);

        if (targetDate == null) {
            return null;
        }

        // determine search order based on preferences
        if (preferences.inPeriod == MeetingTimingPreferences.InPeriodPreference.EARLIEST) {
            return findEarliestSlot(targetDate, meetingDurationMinutes, preferences.period);
        } else {
            return findLatestSlot(targetDate, meetingDurationMinutes, preferences.period);
        }
    }

    private LocalDate getTargetDate(MeetingTimingPreferences.PeriodPreference period) {
        return switch (period) {
            case TODAY, THIS_WEEK -> today;
            case TOMORROW -> today.plusDays(1);
        };
    }

    private LocalDateTime findEarliestSlot(LocalDate startDate, long meetingDurationMinutes,
                                           MeetingTimingPreferences.PeriodPreference period) {
        LocalDate endDate = getEndDate(startDate, period);

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            for (int hour = 0; hour < 24; hour++) {
                for (int minute = 0; minute < 60; minute++) {
                    LocalDateTime gmtTime = LocalDateTime.of(date, LocalTime.of(hour, minute));
                    if (canScheduleMeeting(gmtTime, meetingDurationMinutes)) {
                        return gmtTime;
                    }
                }
            }
        }
        return null;
    }

    private LocalDateTime findLatestSlot(LocalDate startDate, long meetingDurationMinutes,
                                         MeetingTimingPreferences.PeriodPreference period) {
        LocalDate endDate = getEndDate(startDate, period);

        for (LocalDate date = endDate; !date.isBefore(startDate); date = date.minusDays(1)) {
            for (int minute = 24 * 60 - 1; minute >= 0; minute--) {
                int hour = minute / 60;
                int min = minute % 60;
                LocalDateTime gmtTime = LocalDateTime.of(date, LocalTime.of(hour, min));
                if (canScheduleMeeting(gmtTime, meetingDurationMinutes)) {
                    return gmtTime;
                }
            }
        }
        return null;
    }

    private LocalDate getEndDate(LocalDate startDate, MeetingTimingPreferences.PeriodPreference period) {
        if (Objects.requireNonNull(period) == MeetingTimingPreferences.PeriodPreference.THIS_WEEK) {// week runs sunday to saturday
            // find the saturday of the current week
            int dayOfWeek = startDate.getDayOfWeek().getValue(); // Monday=1, ..., Sunday=7

            // if it's sunday (7), saturday is 6 days ahead
            // if it's monday (1), saturday is 5 days ahead
            // if it's saturday (6), saturday is today (0 days ahead)
            int daysUntilSaturday;
            if (dayOfWeek == 7) { // Sunday
                daysUntilSaturday = 6;
            } else {
                daysUntilSaturday = 6 - dayOfWeek;
            }
            return startDate.plusDays(daysUntilSaturday);
        }
        return startDate;
    }

    private boolean canScheduleMeeting(LocalDateTime gmtMeetingStart, long durationMinutes) {
        LocalDateTime gmtMeetingEnd = gmtMeetingStart.plusMinutes(durationMinutes);

        for (Developer dev : team) {
            String timeZoneId = CITY_TO_TIMEZONE.get(dev.city);
            if (timeZoneId == null) {
                throw new IllegalArgumentException("Unknown city: " + dev.city);
            }

            ZoneId devZone = ZoneId.of(timeZoneId);

            ZonedDateTime devMeetingStart = gmtMeetingStart.atZone(ZoneId.of("GMT"))
                    .withZoneSameInstant(devZone);
            ZonedDateTime devMeetingEnd = gmtMeetingEnd.atZone(ZoneId.of("GMT"))
                    .withZoneSameInstant(devZone);

            LocalDateTime devWorkStart = LocalDateTime.of(devMeetingStart.toLocalDate(), dev.workDayStartTime);
            LocalDateTime devWorkEnd = devWorkStart.plusHours(8);

            if (devMeetingStart.toLocalDateTime().isBefore(devWorkStart) ||
                    devMeetingEnd.toLocalDateTime().isAfter(devWorkEnd)) {
                return false;
            }
        }

        return true;
    }
}

//    @Override
//    public LocalDateTime schedule(long meetingDurationMinutes, MeetingTimingPreferences preferences) {
//        LocalDateTime periodBeginning;
//        LocalDateTime periodEnding;
//        if (preferences.period == MeetingTimingPreferences.PeriodPreference.TODAY) {
//            periodBeginning = today.atStartOfDay();
//            periodEnding = today.atTime(23, 59, 59);
//
//        }
//        if (preferences.period == MeetingTimingPreferences.PeriodPreference.TOMORROW) {
//            periodBeginning = today.plusDays(1).atStartOfDay();
//            periodEnding = today.plusDays(1).atTime(23, 59, 59);
//
//        }
//        if (preferences.period == MeetingTimingPreferences.PeriodPreference.THIS_WEEK) {
//            periodBeginning = today.plusDays(6).atStartOfDay();
//            periodEnding = today.plusDays(6).atTime(23, 59, 59);
//
//        }
//    }

//    private LocalDateTime scheduleInBetween(LocalDateTime begin, LocalDateTime end) {
//        for (LocalDateTime proposeTime = begin; proposeTime.isBefore(end); proposeTime = proposeTime.plusMinutes(1)) {
//            for (Developer developer : team) {
//
//            }
//        }
//    }

