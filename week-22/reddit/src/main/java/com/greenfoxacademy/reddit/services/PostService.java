package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Page<Post> listPosts(Integer page);
    //List<Post> listPosts();
    void addPost(Post post);
    void changeScore(Long id, int number);
    void setUser(Post post, String name);
}
