package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.entities.Post;
import com.greenfoxacademy.reddit.models.entities.User;
import com.greenfoxacademy.reddit.models.entities.Vote;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import com.greenfoxacademy.reddit.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;
    private UserService userService;
    private VoteRepository voteRepository;

    @Autowired
    private PostServiceImpl(PostRepository postRepository, UserService userService, VoteRepository voteRepository) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.voteRepository = voteRepository;
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
    public void changeScore(String name, Long postId, int value) {
        User user = userService.findByName(name);
        Post post = findById(postId);
        if (user != null && post != null) {
            Vote vote = new Vote(post, user, value);
            Optional<Vote> optionalVote = voteRepository.findVoteByUserAndPost(user, post);
            if (!optionalVote.isPresent()) {
                voteRepository.save(vote);
                post.addVote(vote);
                post.changeScore(value);
            } else {
                if (optionalVote.get().getValue() == - value) {
                    post.changeScore(2 * value);
                    optionalVote.get().setValue(value);
                    voteRepository.save(optionalVote.get());
                }
            }
            postRepository.save(post);
        }
    }

    @Override
    public void voteUp(String name, Long postId) {
        User user = userService.findByName(name);
        Post post = findById(postId);
        if (user != null && post != null) {
            Vote vote = new Vote(post, user, 1);
            Optional<Vote> optionalVote = voteRepository.findVoteByUserAndPost(user, post);
            if (!optionalVote.isPresent()) {
                voteRepository.save(vote);
                post.addVote(vote);
                post.changeScore(1);
            } else {
                if (optionalVote.get().getValue() == -1) {
                    post.changeScore(2);
                    optionalVote.get().setValue(1);
                    voteRepository.save(optionalVote.get());
                }
            }
            postRepository.save(post);
        }
    }

    @Override
    public void voteDown(String name, Long postId) {
        User user = userService.findByName(name);
        Post post = findById(postId);
        if (user != null && post != null) {
            Vote vote = new Vote(post, user, -1);
            Optional<Vote> optionalVote = voteRepository.findVoteByUserAndPost(user, post);
            if (!optionalVote.isPresent()) {
                voteRepository.save(vote);
                post.addVote(vote);
                post.changeScore(-1);
            } else {
                if (optionalVote.get().getValue() == 1) {
                    post.changeScore(-2);
                    optionalVote.get().setValue(-1);
                    voteRepository.save(optionalVote.get());
                }
            }
            postRepository.save(post);
        }
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void setUser(Post post, String name) {
        if (name != null) {
            post.setOwner(userService.findByName(name));
            postRepository.save(post);
        }
    }
}
