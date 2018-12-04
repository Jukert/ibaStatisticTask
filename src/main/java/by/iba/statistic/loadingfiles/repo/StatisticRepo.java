package by.iba.statistic.loadingfiles.repo;

import by.iba.statistic.loadingfiles.common.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepo extends JpaRepository<Statistic, Long> {
}
