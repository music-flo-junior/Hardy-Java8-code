package com.java.study.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 10. 10
 */
public class CautionEx {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2016, 1, 31).plusMonths(1);
        System.out.println(localDate);

        // 해당 월 첫번째 월요일
        LocalDate firstMonday = LocalDate.of(2020, 10, 1)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        System.out.println(firstMonday);

        System.out.println(getNthMonday(2020, Month.OCTOBER, 1, 2));

        System.out.println(firstMonday.withMonth(11));
    }

    private static LocalDate getNthMonday(int year, Month month, int day, int n) {
        return LocalDate.of(year, month, day)
                .with(TemporalAdjusters.dayOfWeekInMonth(n, DayOfWeek.MONDAY));
    }

}
