package com.greenfoxacademy.listingtodosmysql.controllers;

import com.greenfoxacademy.listingtodosmysql.models.Assignee;
import com.greenfoxacademy.listingtodosmysql.services.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assignees")
public class AssigneeController {

    private AssigneeService assigneeService;

    @Autowired
    public AssigneeController(AssigneeService assigneeService) {
        this.assigneeService = assigneeService;
    }

    @GetMapping(value = {"/", "/list"})
    public String listAssignees(Model model) {
        model.addAttribute("assignees", assigneeService.findAll());
        return "assignees";
    }

    @GetMapping("/add")
    public String renderAddAssigneeForm(Model model, @ModelAttribute("assignee") Assignee assignee) {
        model.addAttribute("assignee", assignee);
        return "add-assignee";
    }

    @PostMapping("/add")
    public String addNewAssignee(@ModelAttribute("assignee") Assignee newAssignee) {
        assigneeService.add(newAssignee);
        return "redirect:/assignees/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteAssignee(@PathVariable(value = "id", required = false) Long id) {
        assigneeService.delete(id);
        return "redirect:/assignees/list";
    }

    @GetMapping("/{id}/edit")
    public String renderEditAssigneeForm(Model model, @PathVariable(value = "id", required = false) Long id) {
        model.addAttribute("assignee", assigneeService.find(id));
        return "edit-assignee";
    }

    @PostMapping("/{id}/edit")
    public String editAssignee(@ModelAttribute("assignee") Assignee editedAssignee) {
        assigneeService.save(editedAssignee);
        return "redirect:/assignees/list";
    }

    @GetMapping("/{id}/todos")
    public String listAssignedTodos(Model model, @PathVariable(value = "id", required = false) Long id) {
        model.addAttribute("todos", assigneeService.getAssignedTodos(id));
        model.addAttribute("name", assigneeService.find(id));
        return "assigned-todos";
    }
}
