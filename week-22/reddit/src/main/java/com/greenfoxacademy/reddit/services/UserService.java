package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.entities.Post;
import com.greenfoxacademy.reddit.models.entities.User;

public interface UserService {
    User findById(Long id);
    User findByName(String name);
    User loginUser(User user);
    void save(User user);
    void setPost(Post post, String name);
    public boolean checkNewUsername (User user);
    public boolean checkEmails(User user);
}
