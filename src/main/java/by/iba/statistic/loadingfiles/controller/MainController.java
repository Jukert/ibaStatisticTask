package by.iba.statistic.loadingfiles.controller;

import by.iba.statistic.loadingfiles.common.SpecificFile;
import by.iba.statistic.loadingfiles.loader.FileLoader;
import by.iba.statistic.loadingfiles.service.FileSchedule;
import by.iba.statistic.loadingfiles.service.FileService;
import by.iba.statistic.loadingfiles.service.StatisticService;
import by.iba.statistic.loadingfiles.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {

    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private StatisticService statisticService;
    @Autowired
    private FileService fileService;
    @Autowired
    private FileSchedule fileSchedule;

    @GetMapping("/")
    public String main(Model model) {
        return "head";
    }

    @PostMapping("/file")
    public String loadStatistic(
            @RequestParam("loadFile") MultipartFile loadFile,
            @RequestParam String date,
            @RequestParam String time,
            Model model
    ) throws IOException {

        if (loadFile == null || loadFile.getOriginalFilename().isEmpty()) {
            model.addAttribute("message", "SpecificFile not found or name is invalid!!!");
        } else {
            FileLoader fileLoader = new FileLoader(uploadPath);
            File resultFile = fileLoader.save(loadFile);
            SpecificFile specificFileInfo = fileService.saveFileInfo(resultFile.getName(), DateUtil.getUnix(String.format("%s %s:00", date, time)), resultFile.length());
            statisticService.add(resultFile.getName(), specificFileInfo.getId());
            fileSchedule.addFile(specificFileInfo);
        }
        return "head";
    }

}
