package com.greenfox.gfa.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileSavingService {
    private static final String fileName ="C:\\Users\\Dóri\\Greenfox\\KecskesDora\\week-18\\dependency\\GreenfoxClassApp\\src\\main\\resources\\templates\\names.txt";

    public List<String> readFile() {
        Path filePath = Paths.get(fileName);
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.err.println("Unable to read file.");
        }
        return lines;
    }

    public void writeFile(List<String> names) {

        try {
            Files.write(Paths.get(fileName), names);
        } catch (IOException e) {
            System.err.println("Unable to write file.");
        }
    }
}
