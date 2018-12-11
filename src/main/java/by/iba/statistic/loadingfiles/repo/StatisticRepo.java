package by.iba.statistic.loadingfiles.repo;

import by.iba.statistic.loadingfiles.common.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StatisticRepo extends JpaRepository<Statistic, Long> {
    List<Statistic> findByFileId(Long id);
    List<Statistic> findByClassName(String className);
    @Query("select " +
            "s.className,s.methodName, max(s.endTime-s.startTime), min(s.endTime-s.startTime), avg(s.endTime-s.startTime), count(s) " +
            "from Statistic s " +
            "group by s.className, s.methodName " +
            "having count(s)>1")
    List<Statistic> findDuplicate();
}
