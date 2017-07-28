package com.dementevay.voting.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
public class TimeUtil {
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }

    public static String formatDateTime (LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    public static LocalDateTime stringToLocalDateTime (String s) {
        return LocalDateTime.parse(s, DATE_TIME_FORMATTER);
    }
}