package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    private PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> listPosts() {
        return postRepository.findAll();
    }

    public void addPost(Post newPost) {
        postRepository.save(newPost);
    }

    public void voteUp(Long id) {
       Optional<Post> post = postRepository.findById(id);
        assert post.orElse(null) != null;
        post.orElse(null).setScore(1);
    }

    public void voteDown(Long id) {
        Optional<Post> post = postRepository.findById(id);
        assert post.orElse(null) != null;
        post.orElse(null).setScore(-1);
    }
}
