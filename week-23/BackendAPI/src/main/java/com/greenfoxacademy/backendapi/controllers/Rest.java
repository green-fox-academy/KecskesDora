package com.greenfoxacademy.backendapi.controllers;

import com.greenfoxacademy.backendapi.models.dtos.ErrorMessage;
import com.greenfoxacademy.backendapi.models.entities.Doubling;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    @GetMapping("/doubling")
    public ResponseEntity doubling(@RequestParam (required = false) Integer input) {
        if (input == null) {
            return ResponseEntity.status(200).body(new ErrorMessage("Please provide an input!"));
        } else {
            return ResponseEntity.status(200).body(new Doubling(input));
        }
    }

    @GetMapping("/doubling")
    public ResponseEntity greeter(@RequestParam (required = false) String name, @RequestParam (required = false) String title) {

    }
}

