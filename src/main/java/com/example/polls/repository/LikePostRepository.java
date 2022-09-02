package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.LikePost;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {

}
