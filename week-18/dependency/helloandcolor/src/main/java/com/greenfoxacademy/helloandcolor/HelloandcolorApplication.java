package com.greenfoxacademy.helloandcolor;

import com.greenfoxacademy.helloandcolor.services.MyColor;
import com.greenfoxacademy.helloandcolor.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloandcolorApplication implements CommandLineRunner {

    private Printer printer;
    private MyColor color;

    @Autowired
    HelloandcolorApplication(Printer printer, MyColor color) {
        this.printer = printer;
        this.color = color;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloandcolorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        printer.log("hello");
        color.printColor();
    }
}
