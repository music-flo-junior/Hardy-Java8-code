package com.java.study.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Hardy(조민국) / dev.mingood@sk.com
 * @since 2020. 10. 09
 */
public class DateTimeApp {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

        System.out.println("===================================");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println("DateTimeFormat : " + now.format(formatter));

        LocalDate parse = LocalDate.parse("10/10/1992", formatter);
        System.out.println(parse);

        LocalDateTime birthDay = LocalDateTime.of(1992, Month.OCTOBER, 10, 0, 0, 0, 0);
        System.out.println(birthDay);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthDay = LocalDate.of(2020, Month.OCTOBER, 10);

        Period between = Period.between(today, thisYearBirthDay);
        System.out.println(between.getDays());

        Period until = today.until(thisYearBirthDay);
        System.out.println(until.get(ChronoUnit.DAYS));

        Instant now1 = Instant.now();
        Instant plus = now1.plus(10, ChronoUnit.SECONDS);
        Duration duration = Duration.between(now1, plus);
        System.out.println(duration.getSeconds());
    }

}
