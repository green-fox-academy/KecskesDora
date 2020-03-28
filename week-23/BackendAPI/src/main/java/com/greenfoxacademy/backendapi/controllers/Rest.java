package com.greenfoxacademy.backendapi.controllers;

import com.greenfoxacademy.backendapi.services.Services;
import com.greenfoxacademy.backendapi.models.dtos.ErrorMessage;
import com.greenfoxacademy.backendapi.models.entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Rest {

    private Services service;

    public Rest(Services service) {
        this.service = service;
    }

    @GetMapping("/doubling")
    public ResponseEntity doubling(@RequestParam(required = false) Integer input) {
        if (input == null) {
            return ResponseEntity.status(200).body(new ErrorMessage("Please provide an input!"));
        } else {
            return ResponseEntity.status(200).body(new Doubling(input));
        }
    }

    @GetMapping("/greeter")
    public ResponseEntity greeter(@RequestParam(required = false) String name, @RequestParam(required = false) String title) {
        if (name == null && title == null) {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide a name and a title!"));
        } else if (name != null && title == null) {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide a title!"));
        } else if (name == null && title != null) {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide a name!"));
        } else {
            return ResponseEntity.status(200).body(new Greeter(name, title));
        }
    }

    @GetMapping("/appenda/{appendable}")
    public ResponseEntity appendA(@PathVariable(required = false) String appendable) {
        if (appendable == null) {
            return ResponseEntity.status(404).body(new ErrorMessage("Please provide an input!"));
        } else {
            return ResponseEntity.status(200).body(new AppendA(appendable));
        }
    }

    @PostMapping("/dountil/{action}")
    public ResponseEntity doUntil(@RequestBody DoUntil until, @PathVariable String action) {
        if (until == null) {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide a number!"));
        } else if (action.equals("sum") || action.equals("factor")) {
            return ResponseEntity.status(200).body(new Result(service.action(until, action)));
        } else {
            return ResponseEntity.status(404).body(new ErrorMessage("No action found"));
        }
    }

    @PostMapping("/arrays")
    public ResponseEntity arrayHandler(@RequestBody ArrayHandler arrayHandler) {
        if (arrayHandler.getWhat().equals("sum") || arrayHandler.getWhat().equals("multiply")) {
            return ResponseEntity.status(200).body(new Result(service.arrayHandler(arrayHandler, arrayHandler.getWhat())));
        } else if (arrayHandler.getWhat().equals("double")) {
            return ResponseEntity.status(200).body(new ResultArray(service.doubleElements(arrayHandler)));
        } else {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide what to do with the numbers!"));
        }
    }
}

