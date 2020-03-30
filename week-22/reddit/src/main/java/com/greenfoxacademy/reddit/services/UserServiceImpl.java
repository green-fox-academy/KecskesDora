package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.entities.Post;
import com.greenfoxacademy.reddit.models.entities.User;
import com.greenfoxacademy.reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name).orElse(null);
    }

    @Override
    public User loginUser(User user) {
        return userRepository.findByNameAndPassword(user.getName(), user.getPassword()).orElse(null);
    }

    @Override
    public boolean checkNewUsername(User user) {
        if (findByName(user.getName()) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkEmails(User user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void setPost(Post post, String name) {
        if (name != null) {
            findByName(name).addPost(post);
        }
    }
}

