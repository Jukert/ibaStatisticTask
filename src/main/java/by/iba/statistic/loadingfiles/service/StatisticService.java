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
    private int i = 0;

    public List<Statistic> add(String filename, long id){
        String currentPath = String.format(
                "%s/%s",
                filePath,
                filename
        );
        FileReader fileReader = new FileReader(currentPath);
        return statisticRepo.saveAll(fileReader.read(id));
    }

    public List<Statistic> getStatisticById(Long id) {
        return statisticRepo.findByFileId(id);
    }

    public List<Statistic> getAllStatistic() {
        return statisticRepo.findAll();
    }

    public List<Statistic> getStatisticByClassName(String className) {
        return statisticRepo.findByClassName(className);
    }

    public List<Statistic> getDuplicate() {
        return statisticRepo.findDuplicate();
    }
}
