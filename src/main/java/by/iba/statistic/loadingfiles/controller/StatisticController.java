package by.iba.statistic.loadingfiles.controller;

import by.iba.statistic.loadingfiles.common.DiskSpace;
import by.iba.statistic.loadingfiles.common.Percentile;
import by.iba.statistic.loadingfiles.common.SpecificFile;
import by.iba.statistic.loadingfiles.common.Statistic;
import by.iba.statistic.loadingfiles.service.FileService;
import by.iba.statistic.loadingfiles.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class StatisticController {
    @Autowired
    private FileService fileService;
    @Autowired
    private StatisticService statisticService;
    @Value("${upload.path}")
    private String filePath;

    @ResponseBody
    @GetMapping("/api/files")
    public List<SpecificFile> files() {
        return fileService.filesAllNormaliseName();
    }

    @ResponseBody
    @GetMapping("/api/files/{file}")
    public List<Statistic> infoClassesByFileId(@PathVariable(name = "file") Long id) {
        return statisticService.getStatisticById(id);
    }

    @ResponseBody
    @GetMapping("/api/classes")
    public List<Statistic> informationClasses(@RequestParam(name = "name", required = false) String className) {
        if (className == null)
            return statisticService.getAllStatistic();
        return statisticService.getStatisticByClassName(className);
    }

    @ResponseBody
    @GetMapping("/api/statistic")
    public List<Statistic> detailsStatistic() {
        return statisticService.getDuplicate();
    }

    @ResponseBody
    @GetMapping("/api/bars")
    public List<Statistic> detailsRunTime() {
        return statisticService.getAllStatistic();
    }

    @ResponseBody
    @GetMapping("/api/pies")
    public DiskSpace memoryFilling() {
        File dirFiles = new File(filePath);
        return new DiskSpace(dirFiles.length(), dirFiles.getFreeSpace());
    }

    @ResponseBody
    @GetMapping("api/percentiles")
    public List<Percentile> countPercentile() {
        List<Statistic> statistics = statisticService.getAllStatistic();
        return new ArrayList<>(Collections.singleton(new Percentile(
                statistics.get(25 / 100 * statistics.size()).getEndTime() - statistics.get(25 / 100 * statistics.size()).getStartTime(),
                statistics.get(50 / 100 * statistics.size()).getEndTime() - statistics.get(25 / 100 * statistics.size()).getStartTime(),
                statistics.get(75 / 100 * statistics.size()).getEndTime() - statistics.get(25 / 100 * statistics.size()).getStartTime(),
                statistics.get(statistics.size() - 1).getEndTime() - statistics.get(25 / 100 * statistics.size()).getStartTime()
        )));
    }

    @GetMapping(value = {
            "/tables",
            "/tables/files",
            "/tables/classes",
            "/tables/statistic",
            "/tables/percentiles"
    })
    public String pageTables(Model model) {
        return "tableStats";
    }

    @GetMapping("/charts")
    public String pageDiagrams() {
        return "diagrams";
    }
}
