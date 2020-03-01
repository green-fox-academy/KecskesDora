package com.greenfox.gfa.services;

import java.util.List;

public interface GfaService {
    List<String> findAll();
    void save(String student);
    Integer count();
    String checkName(String name);
}
