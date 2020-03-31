package com.greenfoxacademy.backendapi.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    private List<Log> entries;
    @JsonProperty("entry_count")
    private int entryCount;

    public Logs() {
    }

    public Logs(List<Log> entries) {
        this.entries = entries;
        entryCount = entries.size();
    }

    public List<Log> getEntries() {
        return entries;
    }

    public void setEntries(List<Log> entries) {
        this.entries = entries;
    }

    public int getEntryCount() {
        return entryCount;
    }

    public void setEntryCount(int entryCount) {
        this.entryCount = entryCount;
    }
}
