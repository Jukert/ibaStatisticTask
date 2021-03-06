package by.iba.statistic.loadingfiles.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final String PATTERN_DATE = "yyy-MM-dd HH:mm:ss";

    public static long getUnix(String date) {
        return LocalDateTime
                .parse(date, DateTimeFormatter.ofPattern(PATTERN_DATE))
                .atZone(ZoneOffset.UTC)
                .toEpochSecond();
    }
}
