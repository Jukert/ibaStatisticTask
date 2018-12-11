package by.iba.statistic.loadingfiles.service;

import by.iba.statistic.loadingfiles.common.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

@Service
@EnableScheduling
public class FileSchedule {
    @Autowired
    private FileService fileService;
    @Value("${upload.path}")
    private String filePath;
    private static List<File> files = null;
    private static Long dateNow;

    @Scheduled(fixedRate = 15000)
    public void removeDeprecatesFile(){
        if (files == null)
            files = fileService.fileList();
        dateNow = Instant.now().atZone(ZoneId.of("UTC+00:00")).toEpochSecond();
        files.stream().forEach(x->{
            if (dateNow >= x.getSaveTime() && x.isFileCondition()) {
                java.io.File f = new java.io.File(
                        String.format(
                                "%s/%s",
                                filePath,
                                x.getName()
                        )
                );
                if (f.delete()) {
                    System.out.println("File " + x.getName() + " was deleted " + dateNow);
                    x.setFileCondition(false);
                    fileService.updateFile(x);
                }
                else {
                    System.out.println(x.getName()+"----------------");
                }
            }
        });
    }

    public static void addFile(File file){
        files.add(file);
    }
}
