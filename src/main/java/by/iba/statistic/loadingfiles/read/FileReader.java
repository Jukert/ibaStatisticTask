package by.iba.statistic.loadingfiles.read;

import by.iba.statistic.loadingfiles.common.Statistic;
import by.iba.statistic.loadingfiles.util.FileParser;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

    @Value("${upload.path}")
    private String uploadPath;
    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public List<Statistic> read() throws IOException {
        List<Statistic> statistics = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(uploadPath+"/"+fileName),StandardCharsets.UTF_8)){
            stream.forEach(s -> statistics.add(FileParser.getStatistic(s)));
        }catch (IOException e){
            e.printStackTrace();
        }
        return statistics;
    }
}
