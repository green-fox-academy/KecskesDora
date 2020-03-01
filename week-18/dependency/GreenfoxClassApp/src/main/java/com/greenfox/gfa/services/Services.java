package com.greenfox.gfa.services;

import java.util.List;

public interface Services {
    List<String> findAll();
    void save(String student);
    Integer count();
    boolean check(String name);
    String checkName(String name);
}
