package com.example.polls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.polls.model.CommentPost;
@Repository
public interface CommentPostRepository  extends JpaRepository<CommentPost, Long>{

}
