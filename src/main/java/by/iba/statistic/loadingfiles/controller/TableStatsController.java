package by.iba.statistic.loadingfiles.controller;

import by.iba.statistic.loadingfiles.common.File;
import by.iba.statistic.loadingfiles.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tables")
public class TableStatsController {
    @Autowired
    private FileService fileService;

    @GetMapping
    public String pageTables(Model model){
        return "tableStats";
    }

    @GetMapping
    @ResponseBody
    public List<File> getTable(){
        return fileService.filesListAll();
    }
}
