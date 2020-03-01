package com.greenfox.gfa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("txt")
public class TxtService implements GfaService{

    private FileSavingService fileSavingService;

    @Autowired
    public TxtService(FileSavingService fileSavingService) {
        this.fileSavingService = fileSavingService;
    }

    @Override
    public List<String> findAll() {
        return fileSavingService.readFile();
    }

    @Override
    public void save(String student) {
        fileSavingService.writeInFile(fileSavingService.readFile(), student);
    }

    @Override
    public Integer count() {
        return fileSavingService.readFile().size();
    }

    @Override
    public String checkName(String name) {
        if (fileSavingService.readFile().contains(name)) {
            return name + " is in the list.";
        } else {
            return name + " is not in the list.";
        }
    }
}
