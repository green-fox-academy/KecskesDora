package com.greenfoxacademy.reddit.repositories;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.models.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VoteRepository extends CrudRepository<Vote, Long> {
    Optional<Vote> findVoteByUserAndPostAndValue(User user, Post post, int value);
}
