package by.iba.statistic.loadingfiles.service;

import by.iba.statistic.loadingfiles.common.SpecificFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Slf4j
@Service
@EnableScheduling
public class FileSchedule {
    @Autowired
    private FileService fileService;
    @Value("${upload.path}")
    private String filePath;
    private List<SpecificFile> specificFiles = null;
    private Long dateNow;

    @Scheduled(fixedRate = 15000)
    public void removeDeprecatesFile() {
        if (specificFiles == null)
            specificFiles = fileService.fileList();

        dateNow = Instant.now().atZone(ZoneOffset.UTC).toEpochSecond();
        specificFiles.stream().forEach(file -> {
            if (dateNow >= file.getSaveTime() && file.isFileCondition()) {
                File f = new File(String.format("%s/%s", filePath, file.getName()));
                if (f.delete()) {
                    log.info(String.format("File %s was deleted %s", file.getName(), dateNow));
                    file.setFileCondition(false);
                    fileService.updateFile(file);
                } else {
                    log.error(String.format("%s wasn't deleted", file.getName()));
                }
            }
        });
    }

    public void addFile(SpecificFile specificFile) {
        specificFiles.add(specificFile);
    }
}
