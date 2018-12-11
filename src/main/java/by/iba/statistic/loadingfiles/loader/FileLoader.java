package by.iba.statistic.loadingfiles.loader;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileLoader {

    private String uploadPath;

    public FileLoader(String uploadPath) {
        this.uploadPath = uploadPath;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    public File save(MultipartFile loadFile) throws IOException {
        File filePath = new File(
                String.format(
                        "%s/%s",
                        uploadPath,
                        getRandomName(loadFile.getOriginalFilename())
                )
        );
        loadFile.transferTo(filePath);
        return filePath;
    }

    private String getRandomName(String name){
        return String.format(
                "%s.%s",
                UUID.randomUUID().toString(),
                name
        );
    }
}
