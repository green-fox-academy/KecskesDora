package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {

    /*@RequestMapping(value="/greeting", method= RequestMethod.GET)
    public Greeting greeting() {
        return new Greeting(1, "Hello, World");
    }*/

    private AtomicLong numberOfCalls = new AtomicLong();

    @GetMapping(value = "/greeting")
    public Greeting greeting(@RequestParam String name){
        return new Greeting(numberOfCalls.incrementAndGet(), "Hello, " + name + "!");
    }
}
