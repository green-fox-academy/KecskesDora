package com.greenfoxacademy.listingtodosmysql.controllers;

import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /*@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    @ResponseBody
    public String list() {
       return "This is my first Todo";
    }*/

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "todolist";
    }
}
