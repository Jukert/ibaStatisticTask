package by.iba.statistic.loadingfiles.service;

import by.iba.statistic.loadingfiles.common.File;
import by.iba.statistic.loadingfiles.repo.FileRepo;
import by.iba.statistic.loadingfiles.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    @Autowired
    private FileRepo fileRepo;
    public File add(String resultFilename, String date, String time, long length) {
        return fileRepo.save(new File(
                DateUtil.getUnix(
                        String.format(
                                "%s %s:00",
                                date,
                                time
                        )
                ),
                length,
                resultFilename
        ));
    }
}

