package com.greenfoxacademy.backendapi.controllers;

import com.greenfoxacademy.backendapi.services.ArrayHandlerService;
import com.greenfoxacademy.backendapi.services.DoUntilService;
import com.greenfoxacademy.backendapi.services.LogService;
import com.greenfoxacademy.backendapi.models.dtos.ErrorMessage;
import com.greenfoxacademy.backendapi.models.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Rest {

    private DoUntilService doUntilService;
    private ArrayHandlerService arrayHandlerService;
    private LogService logService;

    @Autowired
    public Rest(DoUntilService doUntilService, ArrayHandlerService arrayHandlerService, LogService logService) {
        this.doUntilService = doUntilService;
        this.arrayHandlerService = arrayHandlerService;
        this.logService = logService;
    }

    @GetMapping("/doubling")
    public ResponseEntity doubling(@RequestParam(required = false) Integer input) {
        logService.save(new Log("/doubling", "input=" + input));
        if (input == null) {
            return ResponseEntity.status(200).body(new ErrorMessage("Please provide an input!"));
        } else {
            return ResponseEntity.status(200).body(new Doubling(input));
        }
    }

    @GetMapping("/greeter")
    public ResponseEntity greeter(@RequestParam(required = false) String name, @RequestParam(required = false) String title) {
        logService.save(new Log("/greeter", "name=" + name + "&title=" + title));
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
        logService.save(new Log("/appenda", appendable));
        if (appendable == null) {
            return ResponseEntity.status(404).body(new ErrorMessage("Please provide an input!"));
        } else {
            return ResponseEntity.status(200).body(new AppendA(appendable));
        }
    }

    @PostMapping("/dountil/{action}")
    public ResponseEntity doUntil(@RequestBody DoUntil until, @PathVariable String action) {
        logService.save(new Log("/dountil/" + action , until.toString()));
        if (until == null) {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide a number!"));
        } else if (action.equals("sum") || action.equals("factor")) {
            return ResponseEntity.status(200).body(new Result(doUntilService.action(until, action)));
        } else {
            return ResponseEntity.status(404).body(new ErrorMessage("No action found"));
        }
    }

    @PostMapping("/arrays")
    public ResponseEntity arrayHandler(@RequestBody ArrayHandler arrayHandler) {
        logService.save(new Log("/arrays", arrayHandler.toString()));
        if (arrayHandler.getWhat().equals("sum") || arrayHandler.getWhat().equals("multiply")) {
            return ResponseEntity.status(200).body(new Result(arrayHandlerService.arrayHandler(arrayHandler, arrayHandler.getWhat())));
        } else if (arrayHandler.getWhat().equals("double")) {
            return ResponseEntity.status(200).body(new ResultArray(arrayHandlerService.doubleArrayElements(arrayHandler)));
        } else {
            return ResponseEntity.status(400).body(new ErrorMessage("Please provide what to do with the numbers!"));
        }
    }

    @GetMapping("/log")
    public ResponseEntity listLogs() {
        Logs logs = new Logs(logService.listLogs());
        if(logs.getEntries().isEmpty()) {
            return ResponseEntity.status(400).body(new ErrorMessage("No logs saved yet."));
        }
        return ResponseEntity.status(200).body(logs);
    }
}

