package by.iba.statistic.loadingfiles.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final String patternDate = "yyy-MM-dd HH:mm:ss";

    public static long getUnix(String date){
        return LocalDateTime
                .parse(
                        date,
                        DateTimeFormatter.ofPattern(patternDate)
                )
                .atZone(ZoneId.of("UTC+00:00"))
                .toEpochSecond();
    }
}
