package com.greenfoxacademy.backendapi.models.entities;

public class Doubling {
    private Integer received;
    private Integer result;

    public Doubling(Integer input) {
        this.received = input;
        this.result = 2 * input;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
