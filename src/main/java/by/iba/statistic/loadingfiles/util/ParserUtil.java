package by.iba.statistic.loadingfiles.util;

import by.iba.statistic.loadingfiles.common.File;
import by.iba.statistic.loadingfiles.common.Statistic;

public class ParserUtil {
    public static Statistic getStatistic(String line){
        String data[] = line.split(",");
        return new Statistic(
                new File(),
                data[4],
                data[0],
                data[1],
                DateUtil.getUnix(data[2]),
                DateUtil.getUnix(data[3])
        );
    }
}