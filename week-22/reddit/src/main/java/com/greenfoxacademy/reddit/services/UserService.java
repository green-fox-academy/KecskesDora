package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;

public interface UserService {
    User findById(Long id);
    User findByName(String name);
    void save(User user);
    void setPost(Post post, String name);
}
