package com.greenfoxacademy.reddit.repositories;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.Vote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    Page<Post> findAllByOrderByScoreDesc(Pageable pageable);
    List<Post> findAllByOrderByScoreDesc();
    Optional<Post> findById(Long id);
    Optional<Post> findPostByVotesContains(Vote vote);
}
