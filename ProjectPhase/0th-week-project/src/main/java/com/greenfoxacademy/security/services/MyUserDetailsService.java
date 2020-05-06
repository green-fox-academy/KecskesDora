package com.greenfoxacademy.security.services;

import com.greenfoxacademy.security.models.entities.User;
import com.greenfoxacademy.security.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Qualifier("my")
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    private MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Invalid username and password!");
        } else {
            return user.get();
        }
    }


}
