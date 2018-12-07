package by.iba.statistic.loadingfiles.controller.api;

import by.iba.statistic.loadingfiles.common.File;
import by.iba.statistic.loadingfiles.common.Statistic;
import by.iba.statistic.loadingfiles.service.FileService;
import by.iba.statistic.loadingfiles.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Statistic> informationClasses(@RequestParam(name = "name",required = false) String className){
        System.out.println();
        if (className== null)
            return statisticService.statisticsListAll();

        return statisticService.statListByClassName(className);
    }

    @GetMapping("/files/{file}")
    public List<Statistic> infoClassesByFileId(@PathVariable(name = "file") Long id){
        return statisticService.statisticListById(id);
    }

}
