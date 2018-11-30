package by.iba.statistic.loadingfiles.service;

import by.iba.statistic.loadingfiles.repo.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileRepo fileRepo;


}
