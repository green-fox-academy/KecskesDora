package com.greenfoxacademy.security;

import com.greenfoxacademy.security.models.Role;
import com.greenfoxacademy.security.models.entities.User;
import com.greenfoxacademy.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    private UserService userService;
    private static final String ENVIRONMENT = System.getenv("ENVIRONMENT");

    @Autowired
    public SecurityApplication(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (ENVIRONMENT.equals("Test")) {
            userService.save(new User("admin", "111", "ROLE_ADMIN"));
            userService.save(new User("user", "222", "ROLE_USER"));
        }
    }
}
