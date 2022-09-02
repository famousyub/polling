package com.example.polls.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.polls.model.Post;


@Repository
public interface PostsRepository extends JpaRepository<Post, Long> {
	
	@Query("select p from Post p  order by p.createdDate desc ")
	List<Post>  getAllposts();

}
