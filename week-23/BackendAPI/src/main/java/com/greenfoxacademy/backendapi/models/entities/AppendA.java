package com.greenfoxacademy.backendapi.models.entities;

public class AppendA {
    private String appended;

    public AppendA(String input) {
        appended = input + "a";
    }

    public String getAppended() {
        return appended;
    }

    public void setAppended(String appended) {
        this.appended = appended;
    }
}
