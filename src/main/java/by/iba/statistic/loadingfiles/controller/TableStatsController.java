package by.iba.statistic.loadingfiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tables")
public class TableStatsController {
    @GetMapping(value = {
            "",
            "/files",
            "/classes"
    })
    public String pageTables(Model model){
        return "tableStats";
    }
}
