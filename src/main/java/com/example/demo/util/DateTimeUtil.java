package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    // Private constructor to prevent object creation
    private DateTimeUtil() {
    }

    // Get current date time
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    // Get formatted date time as String
    public static String getFormattedDateTime() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
