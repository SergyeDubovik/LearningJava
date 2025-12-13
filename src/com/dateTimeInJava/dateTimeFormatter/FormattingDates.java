package com.dateTimeInJava.dateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormattingDates {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDate = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime);
        // result: 2025-12-10T23:38:28.4235781, i.e. date time now
        System.out.println(formattedDate);

        String formattedDate1 = DateTimeFormatter.BASIC_ISO_DATE.format(localDateTime);
        // result 20251210
        System.out.println(formattedDate1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        // result: 10-декабря-2025
        System.out.println(dtf.format(localDateTime));

        String formatStyleDate = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(localDateTime);
        // result: 10 дек. 2025 г., 23:55:35
        System.out.println(formatStyleDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DDD", Locale.US);
        System.out.println(formatter.format(LocalDateTime.now()));
    }

    // Other Predefined formatters below
    // https://beginnersbook.com/wp-content/uploads/2017/11/predefined_formatters-1024x377.jpg

    // most common letters for patterns below
    // https://drive.google.com/file/d/1-n8Wgh6-5NHJelBhJklbXWGUPTh6pybG/view
}
