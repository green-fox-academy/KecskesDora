package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.models.dtos.ErrorMessage;
import com.greenfoxacademy.reddit.models.entities.User;
import com.greenfoxacademy.reddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String renderLoginFrom(Model model, @RequestParam (required = false) String error) {
        model.addAttribute("error", error);
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user) {
        User loggedInUser = userService.loginUser(user);
        if (loggedInUser != null) {
            return "redirect:/user/" + user.getName();
        } else {
            return "redirect:/login?error=" + new ErrorMessage("Invalid username or password!");
        }
    }

    @GetMapping("/register")
    public String renderRegistrationForm(Model model, @ModelAttribute User user,
                                         @RequestParam (name = "error", required = false) String error) {

        model.addAttribute("user", user);
        model.addAttribute("error", error);
        return "registration";
    }

    @PostMapping("/register")
    public String addNewUser(@ModelAttribute User user) {
        if (!userService.checkNewUsername(user)) {
            return "redirect:/register?error=" + new ErrorMessage("Username already exist!");
        } else if (!userService.checkEmails(user)) {
            return "redirect:/register?error=" + new ErrorMessage("Given passwords are not correct!");
        }
        userService.save(user);
        return "redirect:/user/" + user.getName();
    }
}
