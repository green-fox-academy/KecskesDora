package com.greenfoxacademy.reddit.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private int score;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh.mm.ss")
    private LocalDate creationDate;
    @ManyToOne
    private User owner;

    public Post() {
        creationDate = LocalDate.now();
    }

    public Post(String title, String url) {
        creationDate = LocalDate.now();
        this.title = title;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void changeScore(int score) {
        this.score += score;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public User getowner() {
        return owner;
    }

    public void setUser(User user) {
        this.owner = user;
    }

    public String getOwnerName() {
        if (owner != null) {
            return owner.getName();
        }
        return "";
    }
}
