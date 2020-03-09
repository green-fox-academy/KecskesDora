package com.greenfoxacademy.listingtodosmysql.controllers;

import com.greenfoxacademy.listingtodosmysql.models.Todo;
import com.greenfoxacademy.listingtodosmysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String listTodos(Model model, @RequestParam(value = "is-active", required = false) String isActive,
                            @RequestParam(value = "search", required = false) String searchedInput) {
        if (isActive == null) {
            model.addAttribute("todos", todoRepository.findAllByOrderByIdAsc());
        } else {
            model.addAttribute("todos", todoRepository.findAllByIsDone(!Boolean.parseBoolean(isActive)));

        }
        if (searchedInput != null) {
            model.addAttribute("todos", todoRepository.findAllByTitleContains(searchedInput));
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

    @RequestMapping(value = {"/{id}/delete"}, method = RequestMethod.GET)
    public String deleteTodo(@PathVariable(value = "id", required = false) Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos/list";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.GET)
    public String renderEditTodoForm(Model model, @PathVariable(value = "id", required = false) Long id) {
        model.addAttribute("todo", todoRepository.findTodoById(id));
        return "edit";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.POST)
    public String editTodo(@ModelAttribute("todo") Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todos/list";
    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.POST)
    public String searchResult(Model model, @RequestParam ("search") String search) {
        model.addAttribute("todos", todoRepository.findAllByTitleContains(search));
        return "redirect:/todos/list";
    }
}

