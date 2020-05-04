package com.greenfoxacademy.security.services;

import com.greenfoxacademy.security.models.entities.User;
import com.greenfoxacademy.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
