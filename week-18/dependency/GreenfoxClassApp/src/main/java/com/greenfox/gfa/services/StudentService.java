package com.greenfox.gfa.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("list")
public class StudentService implements GfaService{
    private List<String> names;

    public StudentService() {
        names = new ArrayList<>();
        names.add("Sanyi");
        names.add("Lilla");
        names.add("John");
    }

    @Override
    public List<String> findAll() {
        return names;
    }

    @Override
    public void save(String student) {
        names.add(student);
    }

    @Override
    public Integer count() {
        return names.size();
    }

    /*@Override
    public boolean check(String name) {
        return names.contains(name);
    }*/

    @Override
    public String checkName(String name) {
        if (names.contains(name)) {
            return name + " is in the list.";
        } else {
            return name + " is not in the list.";
        }
    }
}