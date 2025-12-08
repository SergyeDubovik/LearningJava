package com.dateTimeInJava.scheduleAssistant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public interface SchedulingAssistant {

    LocalDateTime schedule(long meetingDurationMinutes, MeetingTimingPreferences preferences);

    static SchedulingAssistant create(Collection<Developer> team, LocalDate today) {
        return SchedulingAssistantImpl.create(team, today);
    }
}
