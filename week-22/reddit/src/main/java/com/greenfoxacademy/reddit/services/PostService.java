package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<Post> listPosts(Integer page);

    void addPost(Post post);

    void changeScore(Long id, int number);

    void setUser(Post post, String name);
}
