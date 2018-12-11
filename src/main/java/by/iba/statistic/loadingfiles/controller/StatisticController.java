package by.iba.statistic.loadingfiles.controller;

import by.iba.statistic.loadingfiles.common.File;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<File> files() {
        return fileService.filesAllNormaliseName();
    }

    @ResponseBody
    @GetMapping("/api/files/{file}")
    public List<Statistic> infoClassesByFileId(@PathVariable(name = "file") Long id) {
        return statisticService.getStatisticById(id);
    }

    @ResponseBody
    @GetMapping("/api/classes")
    public List<Statistic> informationClasses(@RequestParam(name = "name",required = false) String className) {
        if (className== null)
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
    public Map<String,Long> memoryFilling(){
        java.io.File dirFiles = new java.io.File(filePath);
        Map<String,Long> map = new HashMap<>();
        map.put("fill",dirFiles.length());
        map.put("free",dirFiles.getFreeSpace());
        return map;
    }

    @GetMapping(value = {
            "/tables",
            "/tables/files",
            "/tables/classes",
            "/tables/statistic"
    })
    public String pageTables(Model model) {
        return "tableStats";
    }
    @GetMapping("/charts")
    public String pageDiagrams() {
        return "diagrams";
    }
}
