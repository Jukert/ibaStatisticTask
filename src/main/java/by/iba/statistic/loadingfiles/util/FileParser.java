package by.iba.statistic.loadingfiles.util;

import by.iba.statistic.loadingfiles.common.Statistic;
import by.iba.statistic.loadingfiles.common.User;

public class FileParser {

    public static Statistic getStatistic(String line){
        String data[] = line.split(",");
        return new Statistic(
                new User(
                        data[4]
                ),
                data[0],
                data[1],
                Long.valueOf(data[2]),
                Long.valueOf(data[3])
        );
    }
}
