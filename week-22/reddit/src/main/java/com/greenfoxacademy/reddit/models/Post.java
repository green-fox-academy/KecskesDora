package com.greenfoxacademy.reddit.models;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "posts")
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

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "post")
    private List<Vote> votes;

    public Post() {
        creationDate = LocalDate.now();
        votes = new ArrayList<>();
    }

    public Post(String title, String url) {
        creationDate = LocalDate.now();
        votes = new ArrayList<>();
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public String getOwnerName() {
        if (owner != null) {
            return owner.getName();
        }
        return "";
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }
}
