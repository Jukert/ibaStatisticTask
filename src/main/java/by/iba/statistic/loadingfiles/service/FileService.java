package by.iba.statistic.loadingfiles.service;

import by.iba.statistic.loadingfiles.common.SpecificFile;
import by.iba.statistic.loadingfiles.repo.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private final int FILE_NAME = 1;
    private final int FILE_EXTENSION = 2;
    @Autowired
    private FileRepo fileRepo;
    @Value("${upload.path}")
    private String filePath;

    public SpecificFile saveFileInfo(String resultFilename, long date, long length) {
        return fileRepo.save(new SpecificFile(
                date,
                length,
                resultFilename,
                Instant.now().atZone(ZoneId.of("UTC+00:00")).toEpochSecond()
        ));
    }

    public List<SpecificFile> fileList() {
        return fileRepo.findAll();
    }

    public List<SpecificFile> filesAllNormaliseName() {
        List<SpecificFile> specificFiles = new ArrayList<>();

        for (SpecificFile f : fileRepo.findAll()) {
            String data[] = f.getName().split("\\.");
            f.setName(String.format("%s.%s", data[FILE_NAME], data[FILE_EXTENSION]));
            specificFiles.add(f);
        }

        return specificFiles;
    }

    public SpecificFile updateFile(SpecificFile x) {
        return fileRepo.save(x);
    }
}