package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByName(String name) {
        return userRepository.findByName(name).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void setPost(Post post, String name) {
        if (name != null) {
            User user = findByName(name);
            user.addPost(post);
            userRepository.save(user);
        }

    }
}
