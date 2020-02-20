package com.greenfoxacademy.helloandcolor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Blue implements MyColor {

    private Printer printer;

    @Autowired
    public Blue(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void printColor() {
        printer.log("It is blue in color...");
    }
}
