package common.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class TimeUtils {

    //date convert LocalDateTime
    public static LocalDateTime dateConvert(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date dateTimeConvert(LocalDateTime dateTime) {
        Instant instant = dateTime.toInstant(ZoneOffset.of("+8"));
        return Date.from(instant);
    }

}
