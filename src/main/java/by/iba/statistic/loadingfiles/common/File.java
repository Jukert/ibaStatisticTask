package by.iba.statistic.loadingfiles.common;

import javax.persistence.*;
import java.util.List;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long saveTime;
    private double weight;
    private String format;
    private String name;

    @OneToMany(mappedBy = "file")
    private List<Statistic> statistics;

    public File() {
    }

    public File(long saveTime, double weight, String format, String name) {
        this.saveTime = saveTime;
        this.weight = weight;
        this.format = format;
        this.name = name;
    }

    public File(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(long saveTime) {
        this.saveTime = saveTime;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", saveTime=" + saveTime +
                ", weight=" + weight +
                ", format='" + format + '\'' +
                ", name='" + name + '\'' +
                ", statistics=" + statistics +
                '}';
    }
}
