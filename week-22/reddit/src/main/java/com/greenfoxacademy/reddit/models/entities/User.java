package com.greenfoxacademy.reddit.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String confirmPassword;

    @OneToMany(/*cascade = CascadeType.ALL,*/ mappedBy = "owner")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Vote> votes;

    public User() {
        posts = new ArrayList<>();
        votes = new ArrayList<>();
        password = confirmPassword;
    }

    public User(String name) {
        posts = new ArrayList<>();
        votes = new ArrayList<>();
        this.name = name;
        password = confirmPassword;
    }

    public User(String name, String password, String confirmPassword) {
        posts = new ArrayList<>();
        votes = new ArrayList<>();
        this.name = name;
        this.password = password;
        this.password = confirmPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
