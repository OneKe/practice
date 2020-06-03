package common;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void localDateTimeProcess() {
        String start = "2019-09-12 00:00:00";
        String end = "2020-05-19 23:59:59";
        List<String> list = new ArrayList<>();
        String temp1;
        String temp2;
        LocalDateTime localDateTime = LocalDateTime.parse(start, formatter);
        int year = LocalDateTime.parse(end, formatter).getYear();
        int month = LocalDateTime.parse(end, formatter).getMonthValue();
        int i = 0;
        while (!(year == localDateTime.getYear() && month == localDateTime.getMonthValue())) {
            if (i == 0) {
                temp1 = start;
            } else {
                temp1 = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).format(formatter);
            }
            temp2 = LocalDateTime.of(localDateTime.with(TemporalAdjusters.lastDayOfMonth()).toLocalDate(), LocalTime.MAX).format(formatter);
            list.add(temp1 + "_" + temp2);
            ++i;
            localDateTime = LocalDateTime.parse(start, formatter).plusMonths(i);
        }
        temp1 = localDateTime.format(formatter);
        if (i > 0) {
            temp1 = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).format(formatter);
        }
        temp2 = LocalDateTime.parse(end, formatter).format(formatter);
        list.add(temp1 + "_" + temp2);
        System.out.println();
        list.forEach(System.out::println);
    }

    @Test
    public void localDateProcess() {
        String start = "2019-09-12";
        String end = "2020-04-19";
        List<String> list = new ArrayList<>();
        String temp1;
        String temp2;
        LocalDate localDate = LocalDate.parse(start);
        int year = LocalDate.parse(end).getYear();
        int month = LocalDate.parse(end).getMonthValue();
        int i = 0;
        while (!(year == localDate.getYear() && month == localDate.getMonthValue())) {
            if (i == 0) {
                temp1 = start;
            } else {
                temp1 = localDate.with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
            }
            ++i;
            temp2 = localDate.with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
            list.add(temp1 + "_" + temp2);
            localDate = LocalDate.parse(start).plusMonths(i);
        }
        temp1 = start;
        if (i > 0) {
            temp1 = localDate.with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        temp2 = LocalDate.parse(end).format(DateTimeFormatter.ISO_LOCAL_DATE);
        list.add(temp1 + "_" + temp2);

        System.out.println();
        list.forEach(e -> {
            System.out.print(e);
            System.out.println();
        });
    }
}
