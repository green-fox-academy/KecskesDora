package com.greenfoxacademy.helloandcolor.services;

import org.springframework.beans.factory.annotation.Autowired;

public class Red implements MyColor{

    private Printer printer;

    @Autowired
    public Red(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void printColor() {
        printer.log("It is red in color...");
    }
}