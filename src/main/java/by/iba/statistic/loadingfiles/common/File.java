package by.iba.statistic.loadingfiles.common;

import javax.persistence.*;
import java.util.List;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long saveTime;
    private long weight;
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Statistic> statistics;

    public File() {
    }

    public File(File file) {
        this.saveTime = file.getSaveTime();
        this.weight = file.getWeight();
        this.name = file.getName();
    }

    public File(long saveTime, long weight, String name) {
        this.saveTime = saveTime;
        this.weight = weight;
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

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
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
                ", name='" + name + '\'' +
                ", statistics=" + statistics +
                '}';
    }
}
