package com.greenfoxacademy.reddit.models;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JoinColumn (name = "user_id")
    @ManyToOne
    private User user;

    @JoinColumn (name = "post_id")
    @ManyToOne
    private Post post;
    private int value;

    public Vote() {

    }

    public Vote(Post post, User user) {
        this.post = post;
        this.user = user;
    }

    public Vote(Post post, User user, int value) {
        this.post = post;
        this.user = user;
        this.value = value;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


