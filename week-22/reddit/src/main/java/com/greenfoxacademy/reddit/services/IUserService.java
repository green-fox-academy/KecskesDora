package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.User;

public interface IUserService {
    User findById(Long id);
    User findByName(String name);
}
