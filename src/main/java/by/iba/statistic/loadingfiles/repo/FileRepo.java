package by.iba.statistic.loadingfiles.repo;

import by.iba.statistic.loadingfiles.common.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FileRepo extends CrudRepository<File, Long>, JpaRepository<File, Long> {
}
