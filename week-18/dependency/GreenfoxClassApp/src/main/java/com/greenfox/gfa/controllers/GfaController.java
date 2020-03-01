package com.greenfox.gfa.controllers;

import com.greenfox.gfa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GfaController {
    StudentService service;

    @Autowired
    public GfaController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/gfa")
    public String showMainWithCounter(Model model) {
        model.addAttribute("count", service.count().toString());
        return "main-page";
    }

    @GetMapping("/gfa/list")
    public String listStudents(Model model) {
        model.addAttribute("students", service.findAll());
        return "list";
    }

    @GetMapping("/gfa/add")
    public String addNewStudent() {
        return "add";
    }

    @PostMapping("/gfa/save")
    public String saveNewStudent(@RequestParam(name = "name") String newName) {
        service.save(newName);
        return "redirect:/gfa/list";
    }

    @GetMapping("/gfa/check")
    public String checkStudentForm() {
        return "check";
    }

    @PostMapping("/gfa/check")
    public String checkStudent(Model model, String name) {
        //model.addAttribute("contains", service.check(name));
        model.addAttribute("contains", service.checkName(name));
        return "checked";
    }
}
