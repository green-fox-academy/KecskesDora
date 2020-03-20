package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService{
    private PostRepository postRepository;

    @Autowired
    private PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
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
       /*Optional<Post> optionalPost = postRepository.findById(id);
       if (optionalPost.isPresent()) {
           Post post = optionalPost.get();
           post.setScore(post.getScore() + number);
       }*/
       Post post = postRepository.findById(id).orElse(null);
       assert post != null;
       post.changeScore(number);
       postRepository.save(post);
    }
}
