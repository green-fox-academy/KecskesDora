package com.greenfox.gfa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService implements Services{
    List<String> names;
    FileSavingService fileSavingService;

    @Autowired
    public StudentService(FileSavingService fileSavingService) {
        names = new ArrayList<>();
        /*names.add("Sanyi");
        names.add("Lilla");
        names.add("John");*/
        this.fileSavingService = fileSavingService;
    }

    @Override
    public List<String> findAll() {
        //return names;
        return fileSavingService.readFile();
    }

    @Override
    public void save(String student) {
        //names.add(student);
        names = fileSavingService.readFile();
        names.add(student);
        fileSavingService.writeFile(names);
    }

    @Override
    public Integer count() {
        //return names.size();
        return fileSavingService.readFile().size();
    }

    @Override
    public boolean check(String name) {
        //return names.contains(name);
        return fileSavingService.readFile().contains(name);
    }

    @Override
    public String checkName(String name) {
        //if (names.contains(name)) {
        if (fileSavingService.readFile().contains(name)) {
            return name + " is in the list.";
        } else {
            return name + " is not in the list.";
        }
    }
}