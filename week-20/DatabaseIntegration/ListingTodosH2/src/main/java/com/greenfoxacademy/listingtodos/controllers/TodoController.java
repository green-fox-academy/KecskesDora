package com.greenfoxacademy.listingtodos.controllers;

import com.greenfoxacademy.listingtodos.models.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class TodoController {

    public TodoController() {

    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    @ResponseBody
    public String list() {
       return "This is my first Todo";
    }
}
