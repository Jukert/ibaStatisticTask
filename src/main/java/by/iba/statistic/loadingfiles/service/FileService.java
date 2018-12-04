package by.iba.statistic.loadingfiles.service;

import by.iba.statistic.loadingfiles.common.File;
import by.iba.statistic.loadingfiles.repo.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepo fileRepo;
    @Value("${upload.path}")
    private String filePath;
    public File saveFileInfo(String resultFilename, long date, long length) {
        return fileRepo.save(new File(
                date,
                length,
                resultFilename,
                Instant.now().getEpochSecond()
        ));
    }

    public List<File> filesListAll() {
        List<File> files = new ArrayList<>();
        for (File f :
                fileRepo.findAll()) {
            String data[] = f.getName().split("\\.");
            f.setName(
                    String.format(
                            "%s.%s",
                            data[1],
                            data[2]
                    )
            );
            files.add(f);
        }
        return files;
    }
}