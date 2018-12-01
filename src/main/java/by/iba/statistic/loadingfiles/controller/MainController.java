package by.iba.statistic.loadingfiles.controller;

import by.iba.statistic.loadingfiles.service.StatisticService;
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
import java.util.UUID;

@Controller
public class MainController {

    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private StatisticService statisticService;


    @GetMapping("/")
    public String main(Model model){
        return "head";
    }

    @PostMapping("/file")
    public String loadStatistic(
            @RequestParam("loadFile") MultipartFile loadFile,
            @RequestParam String date,
            @RequestParam String time,
            Model model
    ) throws IOException {
        if (loadFile == null || loadFile.getOriginalFilename().isEmpty()){
            //change model, error load file or file not found....
            model.addAttribute("error","File not found or name is invalid!!!");
            model.addAttribute("numberError","404");
            return "error";
        }
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        String resultFilename = String.format(
                "%s.%s",
                UUID.randomUUID().toString(),
                loadFile.getOriginalFilename()
        );
        File filePath = new File(
                String.format(
                        "%s/%s",
                        uploadPath,
                        resultFilename
                )
        );
        loadFile.transferTo(filePath);
        statisticService.add(resultFilename, date, time, filePath.length());
        return "redirect:/";
    }
}
