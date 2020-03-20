package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;

import java.util.List;

public interface IPostService {
    List<Post> listPosts();
    void addPost(Post post);
    void changeScore(Long id, int number);
}
