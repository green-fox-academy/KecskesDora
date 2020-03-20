package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"/", "/{id}"})
    public String listPosts(Model model, @PathVariable(required = false) Long id) {
        model.addAttribute("posts", postService.listPosts());
        return "index";
    }

    @GetMapping("/submit")
    public String renderSubmitForm(Model model, @ModelAttribute Post post) {
        model.addAttribute("post", post);
        return "submit";
    }

    @PostMapping("/submit")
    public String submitNewPost(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/";
    }

    @GetMapping("/vote-up/{id}")
    public String voteUp(@PathVariable Long id) {
        postService.changeScore(id, 1);
        return "redirect:/";
    }

    @GetMapping("/vote-down/{id}")
    public String voteDown(@PathVariable Long id) {
        postService.changeScore(id, -1);
        return "redirect:/";
    }
}
