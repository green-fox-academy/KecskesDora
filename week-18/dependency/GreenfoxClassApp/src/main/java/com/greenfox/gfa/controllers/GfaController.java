package com.greenfox.gfa.controllers;

import com.greenfox.gfa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String saveNewStudent(@ModelAttribute("name") String name) {
        service.save(name);
        return "redirect:/gfa/list";
    }

    /*@GetMapping("/gfa/count")
    public String countStudents(Model model) {
        model.addAttribute("count", service.count().toString());
        return "main-page";
    }*/

    @GetMapping("/gfa/check")
    public String checkStudentForm(Model model) {
        return "check";
    }

    @PostMapping("/gfa/check")
    public String checkStudent(Model model, @ModelAttribute("name") String name) {
        model.addAttribute("contains", service.check(name));
        return "checked";
    }
}
