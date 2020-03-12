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
                            @RequestParam(name = "searchBy", required = false) String searchBy) {

        if (searchField != null) {
            model.addAttribute("todos", todoService.search(searchField, searchBy));
        } else if (isActive == null) {
            model.addAttribute("todos", todoService.findAll());
        } else {
            model.addAttribute("todos", todoService.findAllByDone(isActive));
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

