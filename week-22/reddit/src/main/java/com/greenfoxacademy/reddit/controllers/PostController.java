package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.services.PostService;
import com.greenfoxacademy.reddit.services.UserService;
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
    private UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping({"/", "/{page}", "/{name}", "/{page}/{name}"})
    public String listPosts(Model model, @PathVariable(required = false) Integer page, @PathVariable(required = false) String name) {
        model.addAttribute("id", name);
        model.addAttribute("posts", postService.listPosts(page));
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping({"/submit", "/{name}/submit"})
    public String renderSubmitForm(Model model, @PathVariable(required = false) String name) {
        model.addAttribute("name", name);
        model.addAttribute("post", new Post());
        return "submit";
    }

    @PostMapping({"/submit", "/{name}/submit"})
    public String submitNewPost(@ModelAttribute Post post, @PathVariable(required = false) String name) {
        postService.addPost(post);
        postService.setUser(post, name);
        userService.setPost(post, name);
        return "redirect:/" + name;
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
