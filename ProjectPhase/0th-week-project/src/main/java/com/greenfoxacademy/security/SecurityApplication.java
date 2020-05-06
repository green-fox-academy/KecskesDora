package com.greenfoxacademy.security;

import com.greenfoxacademy.security.models.Role;
import com.greenfoxacademy.security.models.entities.User;
import com.greenfoxacademy.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    private UserService userService;

    @Autowired
    public SecurityApplication(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.save(new User("user1", "111"));
        userService.save(new User("user2", "222"));
        userService.save(new User("user3", "333"));
    }
}
