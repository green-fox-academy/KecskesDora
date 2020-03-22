package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import com.greenfoxacademy.reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService{
    private PostRepository postRepository;
    private UserService userService;

    @Autowired
    private PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public List<Post> listPosts() {
        return postRepository.findByOrderByScoreDesc();
    }

    @Override
    public void addPost(Post newPost) {
        postRepository.save(newPost);
    }

    @Override
    public void changeScore(Long id, int number) {
        Post post = postRepository.findById(id).orElse(null);
        assert post != null;
        post.changeScore(number);
        postRepository.save(post);
    }

    public void setUser(Post post, String name) {
        if (name != null) {
            post.setUser(userService.findByName(name));
        }
    }
}
