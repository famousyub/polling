package com.example.polls.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.CommentPost;
import com.example.polls.payload.CommentPostRequest;
import com.example.polls.payload.PostRequest;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.CommentPostService;

@RestController
@RequestMapping("/api/commpost")
public class CommentPostController {
	
	@Autowired
	CommentPostService compostser ;
	
	
	@PostMapping("/createcomment/{postId}")
	public ResponseEntity<?> createpostcomment(@CurrentUser UserPrincipal me ,@Valid @RequestBody CommentPostRequest poreq,@PathVariable("postId") Long postId)
	
	{
		
		CommentPost compost = compostser.createPost(me, poreq, postId);
		return ResponseEntity.ok().body(compost);
	}

}
