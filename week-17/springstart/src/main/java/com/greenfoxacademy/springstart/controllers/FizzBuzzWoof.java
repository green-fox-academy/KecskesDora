package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class FizzBuzzWoof {

    private AtomicLong numberOfCalls = new AtomicLong();
    int size = 24;

    @RequestMapping("/fizz-buzz-woof")
    public String fizzBuzzWoof (Model model) {

        model.addAttribute("result", convertNumberOfCallsToString());
        model.addAttribute("size", size);

        return "fizz-buzz-woof";
    }

    public String convertNumberOfCallsToString() {

        int counter = (int) numberOfCalls.incrementAndGet();

        if (counter % 105 == 0) {
            size = 72;
            return "Fizz Buzz Woof";
        } else if (counter % 15 == 0) {
            size = 48;
            return "Fizz Buzz";
        } else if (counter % 21 == 0) {
            size = 48;
            return "Fizz Woof";
        } else if (counter % 35 == 0) {
            size = 48;
            return "Buzz Woof";
        } else if (counter % 3 == 0) {
            size = 24;
            return "Fizz";
        } else if (counter % 5 == 0) {
            size = 24;
            return "Buzz";
        } else if (counter % 7 == 0) {
            size = 24;
            return "Woof";
        } else {
            size = 24;
            return numberOfCalls.toString();
        }
    }
}
