package by.iba.statistic.loadingfiles.common;

import lombok.Data;

@Data
public class Percentile {

    private long percentile_25;
    private long percentile_50;
    private long percentile_75;
    private long percentile_100;

    public Percentile(long percentile_25, long percentile_50, long percentile_75, long percentile_100) {
        this.percentile_25 = percentile_25;
        this.percentile_50 = percentile_50;
        this.percentile_75 = percentile_75;
        this.percentile_100 = percentile_100;
    }
}
