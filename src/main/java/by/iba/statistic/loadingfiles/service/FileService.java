package by.iba.statistic.loadingfiles.service;

import by.iba.statistic.loadingfiles.common.File;
import by.iba.statistic.loadingfiles.repo.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepo fileRepo;
    @Value("${upload.path}")
    private String filePath;
    public File add(String resultFilename, long date, long length) {
        return fileRepo.save(new File(
                date,
                length,
                resultFilename
        ));
    }

    public List<File> filesListAll() {
        return fileRepo.findAll();
    }
}