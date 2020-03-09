package com.greenfoxacademy.listingtodosmysql.controllers;

import com.greenfoxacademy.listingtodosmysql.models.Assignee;
import com.greenfoxacademy.listingtodosmysql.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assignees")
public class AssigneeController {

    private AssigneeRepository assigneeRepository;

    @Autowired
    public AssigneeController(AssigneeRepository assigneeRepository) {
        this.assigneeRepository = assigneeRepository;
    }

    @GetMapping(value = {"/", "/list"})
    public String listAssignees(Model model) {
        model.addAttribute("assignees", assigneeRepository.findAllByOrderByIdAsc());
        return "assignees";
    }

    @GetMapping("/add")
    public String renderAddAssigneeForm(Model model, @ModelAttribute("assignee") Assignee assignee) {
        model. addAttribute("assignee", assignee);
        return "add-assignee";
    }

    @PostMapping("/add")
    public String addNewAssignee(@ModelAttribute("assignee") Assignee newAssignee) {
        assigneeRepository.save(newAssignee);
        return "redirect:/assignees/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteAssignee(@PathVariable(value = "id", required = false) Long id) {
        assigneeRepository.deleteById(id);
        return "redirect:/assignees/list";
    }
}
