package by.iba.statistic.loadingfiles.repo;

import by.iba.statistic.loadingfiles.common.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<File, Long> {
}
