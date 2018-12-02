package by.iba.statistic.loadingfiles.read;

import by.iba.statistic.loadingfiles.common.File;
import by.iba.statistic.loadingfiles.common.Statistic;
import by.iba.statistic.loadingfiles.util.ParserUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    private String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Statistic> read(File file) {
        List<Statistic> statistics = new ArrayList<>();
        try(Stream<String> stream = Files.lines(Paths.get(filePath),StandardCharsets.UTF_8)){
            stream.forEach(s -> statistics.add(ParserUtil.getStatistic(s,file)));
        }catch (IOException e){
            e.printStackTrace();
        }
        return statistics;
    }
}
