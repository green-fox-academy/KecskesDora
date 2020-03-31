package com.greenfoxacademy.backendapi.repositories;

import com.greenfoxacademy.backendapi.models.entities.Log;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogRepository extends CrudRepository<Log, Long> {
    List<Log> findAll();
}
