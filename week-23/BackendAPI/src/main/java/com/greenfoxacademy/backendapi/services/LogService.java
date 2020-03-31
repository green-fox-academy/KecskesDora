package com.greenfoxacademy.backendapi.services;

import com.greenfoxacademy.backendapi.models.entities.Log;
import com.greenfoxacademy.backendapi.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void save(Log newLog) {
        logRepository.save(newLog);
    }

    public List<Log> listLogs() {
        return logRepository.findAll();
    }
}
