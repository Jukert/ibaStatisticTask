package by.iba.statistic.loadingfiles.common;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long saveTime;
    private long dateLoad;
    private long weight;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "file")
    private Set<Statistic> statistics = new HashSet<>();

    public File() {
    }

    public File(File file) {
        this.saveTime = file.getSaveTime();
        this.weight = file.getWeight();
        this.name = file.getName();
    }

    public File(long saveTime, long weight, String name, long dateLoad) {
        this.saveTime = saveTime;
        this.weight = weight;
        this.name = name;
        this.dateLoad = dateLoad;
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

    public Set<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(Set<Statistic> statistics) {
        this.statistics = statistics;
    }

    public long getDateLoad() {
        return dateLoad;
    }

    public void setDateLoad(long dateLoad) {
        this.dateLoad = dateLoad;
    }
}
