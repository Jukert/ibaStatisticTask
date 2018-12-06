package by.iba.statistic.loadingfiles.common;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = false)
    private File file;
    private String user;
    private String className;
    private String methodName;
    private long startTime;
    private long endTime;
    public Statistic() {
    }

    public Statistic(File file,String user, String className, String methodName, long startTime, long endTime) {
        this.file = file;
        this.user = user;
        this.className = className;
        this.methodName = methodName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return id == statistic.id &&
                startTime == statistic.startTime &&
                endTime == statistic.endTime &&
                Objects.equals(file, statistic.file) &&
                Objects.equals(user, statistic.user) &&
                Objects.equals(className, statistic.className) &&
                Objects.equals(methodName, statistic.methodName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, file, user, className, methodName, startTime, endTime);
    }
}
