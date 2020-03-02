package com.greenfoxacademy.listingtodos.models;

import org.springframework.stereotype.Service;

import javax.persistence.Entity;


public class Todo {
    private long id;
    private String title;
    private boolean isUrgent;
    private boolean isDone;

    public Todo() {
        isUrgent = false;
        isDone = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
