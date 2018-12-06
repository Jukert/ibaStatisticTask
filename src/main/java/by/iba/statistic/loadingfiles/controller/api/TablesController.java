package by.iba.statistic.loadingfiles.controller.api;

import by.iba.statistic.loadingfiles.common.File;
import by.iba.statistic.loadingfiles.common.Statistic;
import by.iba.statistic.loadingfiles.service.FileService;
import by.iba.statistic.loadingfiles.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/tables/api")
public class TablesController {
    @Autowired
    private FileService fileService;
    @Autowired
    private StatisticService statisticService;

    @GetMapping("/files")
    public List<File> files(){
        return fileService.filesListAll();
    }


    @GetMapping("/classes")
    public List<Statistic> informationClasses(){
        return statisticService.statisticsListAll();
    }

    @GetMapping("/files/{file}")
    public Set<Statistic> infoClassesByFileId(@PathVariable(name = "file") File file){

        return file.getStatistics();
    }
}
