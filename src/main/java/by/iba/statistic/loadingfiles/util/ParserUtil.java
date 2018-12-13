package by.iba.statistic.loadingfiles.util;

import by.iba.statistic.loadingfiles.common.SpecificFile;
import by.iba.statistic.loadingfiles.common.Statistic;

public class ParserUtil {

    private static final int CLASS_NAME = 0;
    private static final int METHOD_NAME = 1;
    private static final int DATE_METHOD_START = 2;
    private static final int DATE_METHOD_END = 3;
    private static final int USER = 4;

    public static Statistic getStatistic(String line) {
        String data[] = line.split(",");
        return new Statistic(
                new SpecificFile(),
                data[USER],
                data[CLASS_NAME],
                data[METHOD_NAME],
                DateUtil.getUnix(data[DATE_METHOD_START]),
                DateUtil.getUnix(data[DATE_METHOD_END])
        );
    }
}