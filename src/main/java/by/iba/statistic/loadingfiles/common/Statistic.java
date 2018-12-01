package by.iba.statistic.loadingfiles.common;

import javax.persistence.*;

@Entity
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private File file;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    private String className;
    private String methodName;
    private long startTime;
    private long endTime;
    public Statistic() {
    }

    public Statistic(User user, String className, String methodName, long startTime, long endTime) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
    public String toString() {
        return "Statistic{" +
                "id=" + id +
                ", file=" + file +
                ", user=" + user.toString() +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
