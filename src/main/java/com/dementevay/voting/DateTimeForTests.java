package com.dementevay.voting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by Andrey Dementev on 07.08.17.
 */
public class DateTimeForTests {
    public static LocalDateTime localDateTime = LocalDateTime.parse("2017-07-26T10:00:00");
    public static LocalDate localDate = localDateTime.toLocalDate();
    public static LocalTime localTime = localDateTime.toLocalTime();


    public static void setDateTime(LocalDateTime localDateTime) {
        DateTimeForTests.localDateTime = localDateTime;
        localDate = localDateTime.toLocalDate();
        localTime = localDateTime.toLocalTime();
    }
}
