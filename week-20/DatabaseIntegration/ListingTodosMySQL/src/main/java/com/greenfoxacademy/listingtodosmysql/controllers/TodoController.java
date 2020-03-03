package com.greenfoxacademy.listingtodosmysql.controllers;

import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String list(Model model, @RequestParam(value = "isActive", required = false) String isActive) {
        if (isActive == null) {
            model.addAttribute("todos", todoRepository.findAll());
        } else {
            model.addAttribute("todos", todoRepository.findAllByIsDone(!Boolean.parseBoolean(isActive)));
        }
        return "todolist";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String renderAddForm(Model model, @ModelAttribute("todo") Todo todo) {
        model.addAttribute("todo", todo);
        return "add";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addNewTodo(@ModelAttribute("todo") Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todos/list";
    }
}

