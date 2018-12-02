package by.iba.statistic.loadingfiles.util;

import by.iba.statistic.loadingfiles.common.File;
import by.iba.statistic.loadingfiles.common.Statistic;
import by.iba.statistic.loadingfiles.common.User;

public class ParserUtil {

    public static Statistic getStatistic(String line, File file){
        String data[] = line.split(",");
        return new Statistic(
                new File(
                  file
                ),
                new User(
                        data[4]
                ),
                data[0],
                data[1],
                DateUtil.getUnix(data[2]),
                DateUtil.getUnix(data[3])
        );
    }
}
