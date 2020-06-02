package common;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    public void localDateTimeProcess() {
        String start = "2019-09-12 00:00:00";
        String end = "2020-04-19 23:59:59";
        List<String> list = new ArrayList<>();
        String temp1;
        String temp2;
        LocalDateTime localDateTime = LocalDateTime.parse(start, formatter);
        int i = 0;
        boolean month = !localDateTime.isAfter(LocalDateTime.parse(end, formatter));
        while (month) {
            if (i == 0) {
                temp1 = start;
            } else {
                temp1 = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).format(formatter);
            }
            ++i;
            localDateTime = LocalDateTime.parse(start, formatter).plusMonths(i);
            month = !localDateTime.isAfter(LocalDateTime.parse(end, formatter));
            if (!month) {
                temp2 = end;
            } else {
                temp2 = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).format(formatter);
            }
            list.add(temp1 + "_" + temp2);

            System.out.print(month + ",");
        }
        System.out.println();
        list.forEach(e -> {
            System.out.print(e);
            System.out.println();
        });
    }

    @Test
    public void localDateProcess() {
        String start = "2019-09-12";
        String end = "2020-04-19";
        List<String> list = new ArrayList<>();
        String temp1;
        String temp2;
        LocalDate localDateTime = LocalDate.parse(start);
        int i = 0;
        boolean month = !localDateTime.isAfter(LocalDate.parse(end));
        while (month) {
            if (i == 0) {
                temp1 = start;
            } else {
                temp1 = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
            }
            ++i;
            localDateTime = LocalDate.parse(start).plusMonths(i);
            month = !localDateTime.isAfter(LocalDate.parse(end));
            if (!month) {
                temp2 = end;
            } else {
                temp2 = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
            }
            list.add(temp1 + "_" + temp2);

            System.out.print(month + ",");
        }
        System.out.println();
        list.forEach(e -> {
            System.out.print(e);
            System.out.println();
        });
    }
}
