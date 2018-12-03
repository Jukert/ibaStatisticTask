package by.iba.statistic.loadingfiles.repo;

import by.iba.statistic.loadingfiles.common.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<File, Long> {
}
