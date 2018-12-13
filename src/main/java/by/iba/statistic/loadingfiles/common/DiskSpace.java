package by.iba.statistic.loadingfiles.common;

import lombok.Data;

@Data
public class DiskSpace {
    //free disk spaces
    private long free;
    //fill disk spaces
    private long fill;

    public DiskSpace(long free, long fill) {
        this.free = free;
        this.fill = fill;
    }
}
