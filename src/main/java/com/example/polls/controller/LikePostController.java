package com.example.polls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.LikePost;
import com.example.polls.payload.LikepostRequest;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.LikePostService;

@RestController
@RequestMapping("/api/likes")
public class LikePostController {

	
	 @Autowired
	 LikePostService likeservice ;
	 
	 @PostMapping("/addlike/{postId}")
	 public ResponseEntity<?> createLikepost(@CurrentUser UserPrincipal me, @PathVariable("postId") Long id,@RequestBody LikepostRequest lr )
	 {
		 LikePost lk = likeservice.addLikesPost(me, id,lr);
		 return ResponseEntity.ok().body(lk);
		 
	 }
	 
	 
}
