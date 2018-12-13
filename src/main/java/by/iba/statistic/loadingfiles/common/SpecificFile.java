package by.iba.statistic.loadingfiles.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "file")
public class SpecificFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //The time when the file is destroyed
    private long saveTime;
    //The time when file is loaded
    private long dateLoad;
    //File weight
    private long weight;
    private String name;
    //File availability
    private boolean fileCondition = false;

    public SpecificFile(long saveTime, long weight, String name, long dateLoad) {
        this.saveTime = saveTime;
        this.weight = weight;
        this.name = name;
        this.dateLoad = dateLoad;
    }
}
