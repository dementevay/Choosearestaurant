package com.dementevay.voting.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
public class TimeUtil {
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //private final static DateTimeFormatter DATE_T_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:ss");

    //public static final LocalDate MIN_DATE = LocalDate.of(1, 1, 1);
    //public static final LocalDate MAX_DATE = LocalDate.of(3000, 1, 1);

    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }

    public static String formatDateTime (LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    public static LocalDateTime stringToLocalDateTime (String s) {
        if (s.contains(" ")) {
            return LocalDateTime.parse(s, DATE_TIME_FORMATTER);
        } else if (s.length() == 10) {
            return LocalDateTime.parse(s, DATE_FORMATTER);
        } /*else if (s.contains("T")) {
            return LocalDateTime.parse(s, DATE_T_TIME_FORMATTER);
        }*/
        return null;
    }

    public static LocalDate parseLocalDate(String str) {
        return StringUtils.isEmpty(str) ? null : LocalDate.parse(str);
    }

    public static LocalTime parseLocalTime(String str) {
        return StringUtils.isEmpty(str) ? null : LocalTime.parse(str);
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }
}
