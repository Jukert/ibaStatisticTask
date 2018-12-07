package by.iba.statistic.loadingfiles.repo;

import by.iba.statistic.loadingfiles.common.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepo extends JpaRepository<Statistic, Long> {
     List<Statistic> findByFileId(Long id);
     List<Statistic> findByClassName(String className);
}
