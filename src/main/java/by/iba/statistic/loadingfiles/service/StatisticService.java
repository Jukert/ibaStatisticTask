package by.iba.statistic.loadingfiles.service;

import by.iba.statistic.loadingfiles.common.Statistic;
import by.iba.statistic.loadingfiles.read.FileReader;
import by.iba.statistic.loadingfiles.repo.StatisticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    @Autowired
    private StatisticRepo statisticRepo;
    @Value("${upload.path}")
    private String filePath;
    public List<Statistic> add(String filename, long id){
        String currentPath = String.format(
                "%s/%s",
                filePath,
                filename
        );
        FileReader fileReader = new FileReader(currentPath);
        return (List<Statistic>)statisticRepo.saveAll(fileReader.read(id));
    }
}
