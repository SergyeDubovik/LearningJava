package com.epamTasks.fundamentals.timeFormatterExercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class FormatterConfigurerFactory {
    static {
        Locale.setDefault(Locale.ENGLISH);
    }

    private FormatterConfigurerFactory() {
    }

    public static FormatterConfigurer slangBasedDate() {
        return builder -> {
            builder.appendValue(ChronoField.DAY_OF_MONTH)
                    .appendLiteral(' ')
                    .append(DateTimeFormatter.ofPattern("LLL"))
                    .appendLiteral(" of ")
                    .appendValueReduced(ChronoField.YEAR, 2, 4, LocalDate.of(1931, 1, 1));
        };
    }

    public static FormatterConfigurer politeScheduler() {
        return builder -> builder
                .appendLiteral("Scheduled on ")
                .appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL)
                .appendLiteral(" at ")
                .appendValue(ChronoField.CLOCK_HOUR_OF_AMPM)
                .appendLiteral(':')
                .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
                .appendLiteral(' ')
                .append(DateTimeFormatter.ofPattern("B"))
                .optionalStart()
                .appendLiteral(" by ")
                .appendZoneText(TextStyle.FULL)
                .optionalEnd();

    }

    public static FormatterConfigurer scientificTime() {
        return builder -> {
            builder.appendValue(ChronoField.HOUR_OF_DAY, 2)
                    .appendLiteral(':')
                    .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
                    .appendLiteral(':')
                    .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
                    .appendLiteral('.')
                    .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, false);
        };
    }

    public static FormatterConfigurer historicalCalendar() {
        return builder -> {
            builder.appendValue(ChronoField.YEAR_OF_ERA)
                    .appendLiteral(" of ")
                    .appendText(ChronoField.ERA, TextStyle.FULL)
                    .appendLiteral(" (")
                    .appendChronologyText(TextStyle.FULL)
                    .appendLiteral(")");


        };
    }
}
