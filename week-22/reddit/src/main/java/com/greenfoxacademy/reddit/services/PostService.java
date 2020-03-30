package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<Post> listPosts(Integer page);
    void addPost(Post post);
    void changeScore(String name, Long postId, int value);
    void setUser(Post post, String name);
    Post findById(Long id);
    void voteUp(String name, Long postId);
    void voteDown(String name, Long postId);
}
