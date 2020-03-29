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

    @GetMapping({"/", "/user/{name}"})
    public String listPostsOnMainPage(Model model, @PathVariable(required = false) String name) {

        model.addAttribute("name", name);
        model.addAttribute("posts", postService.listPosts(0));
        model.addAttribute("page", 0);
        return "index";
    }

    @GetMapping({"/page/{page}", "page/{page}/user/{name}"})
    public String listPostsOnNextPage(Model model, @PathVariable(required = false) int page, @PathVariable(required = false) String name) {

        model.addAttribute("name", name);
        model.addAttribute("posts", postService.listPosts(page));
        model.addAttribute("page", page);
        return "index";
    }

    @GetMapping({"/submit", "/user/{name}/submit"})
    public String renderSubmitForm(Model model, @PathVariable(required = false) String name) {
        model.addAttribute("name", name);
        model.addAttribute("post", new Post());
        return "submit";
    }

    @PostMapping({"/submit", "/user/{name}/submit"})
    public String submitNewPost(@ModelAttribute Post post, @PathVariable(required = false) String name) {
        postService.addPost(post);
        postService.setUser(post, name);
        userService.setPost(post, name);
        return "redirect:/user/" + name;
    }

    @GetMapping("/user/{name}/vote-up/{postId}")
    public String voteUp(@PathVariable String name, @PathVariable Long postId) {
        postService.changeScore(name, postId, 1);
        return "redirect:/user/" + name;
    }

    @GetMapping("/user/{name}/vote-down/{postId}")
    public String voteDown(@PathVariable String name, @PathVariable Long postId) {
        postService.changeScore(name, postId, -1);
        return "redirect:/user/" + name;
    }
}
