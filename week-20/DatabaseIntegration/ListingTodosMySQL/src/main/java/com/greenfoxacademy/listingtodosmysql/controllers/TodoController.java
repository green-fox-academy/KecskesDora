package com.greenfoxacademy.listingtodosmysql.controllers;

import com.greenfoxacademy.listingtodosmysql.models.Todo;

import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import com.greenfoxacademy.listingtodosmysql.services.AssigneeService;
import com.greenfoxacademy.listingtodosmysql.services.TodoService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;
    private AssigneeService assigneeService;

    @Autowired
    public TodoController(TodoService todoService, AssigneeService assigneeService) {
        this.todoService = todoService;
        this.assigneeService = assigneeService;
    }

    /*@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    @ResponseBody
    public String list() {
       return "This is my first Todo";
    }*/

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listTodos(Model model, @RequestParam(value = "is-active", required = false) String isActive,
                            @RequestParam(name = "search", required = false) String searchField,
                            @RequestParam(name = "search-key", required = false) String searchKey,
                            @RequestParam(name = "search-date", required = false) String searchDateField) {

        if (searchField == null && searchDateField == null & isActive == null) {
            model.addAttribute("todos", todoService.findAll());
        } else if (isActive != null) {
            model.addAttribute("todos", todoService.findAllByDone(isActive));
        } else if (searchField != null && searchKey != null) {
            model.addAttribute("todos", todoService.search(searchField, searchKey));
        } else if (searchDateField != null && searchKey != null) {
            model.addAttribute("todo", todoService.searchDate(searchDateField, searchKey));
        }
        return "todolist";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String renderAddForm(Model model, @ModelAttribute("todo") Todo todo) {
        model.addAttribute("todo", todo);
        return "add-todo";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addNewTodo(@ModelAttribute("todo") Todo todo) {
        todoService.save(todo);
        return "redirect:/todos/list";
    }

    @RequestMapping(value = {"/{id}/delete"}, method = RequestMethod.GET)
    public String deleteTodo(@PathVariable(value = "id", required = false) Long id) {
        todoService.delete(id);
        return "redirect:/todos/list";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.GET)
    public String renderEditTodoForm(Model model, @PathVariable(value = "id", required = false) Long id) {
        model.addAttribute("todo", todoService.find(id));
        model.addAttribute("assignees", assigneeService.findAll());
        return "edit-todo";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.POST)
    public String editTodo(@ModelAttribute("todo") Todo todo) {
        todoService.save(todo);
        assigneeService.addTodo(todo);
        return "redirect:/todos/list";
    }
}

