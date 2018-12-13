package by.iba.statistic.loadingfiles.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "file_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private SpecificFile specificFile;
    private String user;
    private String className;
    private String methodName;
    private long startTime;
    private long endTime;

    public Statistic(SpecificFile specificFile, String user, String className, String methodName, long startTime, long endTime) {
        this.specificFile = specificFile;
        this.user = user;
        this.className = className;
        this.methodName = methodName;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
