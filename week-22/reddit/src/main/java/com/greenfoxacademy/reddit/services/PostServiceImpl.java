package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;
    private UserService userService;

    @Autowired
    private PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public Page<Post> listPosts(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return postRepository.findAllByOrderByScoreDesc(pageable);
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

    @Override
    public void setUser(Post post, String name) {
        if (name != null) {
            post.setUser(userService.findByName(name));
            postRepository.save(post);
        }
    }
}
