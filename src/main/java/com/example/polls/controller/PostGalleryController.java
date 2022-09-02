package com.example.polls.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.model.Post;
import com.example.polls.model.PostGallery;
import com.example.polls.payload.PostGalleryRequest;
import com.example.polls.payload.PostGallresp;
import com.example.polls.payload.PostRequest;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.PostGalleryService;

@RestController
@RequestMapping("/api/galposts")
public class PostGalleryController {
	
	
	 @Autowired
	 PostGalleryService postgalserv;
	 
	 private byte[] postpic ;
	 
	 
	 @PostMapping("/upload")
	 public ResponseEntity<?>   uploadingPhoto(@RequestParam("file") MultipartFile file)
	 {
		 try {
			 this.postpic  =file.getBytes();
			 System.out.println(file.getSize());
			 return ResponseEntity.ok().body("suucess upload");
			 
			 
			 
		 }catch(Exception ex)
		 {
			 return ResponseEntity.badRequest().body("something wrong  upload");
		 }
	 }
	 
	 
	 @PostMapping("/postcreate")
		public ResponseEntity<?> createPosts(@CurrentUser UserPrincipal me ,@Valid @RequestBody PostGalleryRequest poreq){
			
		 
		 if(this.postpic !=null) {
			 
			 poreq.setPostpic(postpic);
			 PostGallery p =  postgalserv.createPost(me, poreq);
					 //new PostGallery();
			// p.setPostpic(postpic);
					
				
				return ResponseEntity.ok().body(p);
		 }
		 else {
			 PostGallery p =  postgalserv.createPost(me, poreq);
			 return ResponseEntity.ok().body(p);
		 }
			
			
		}
		
		@GetMapping("/allposts")
		public ResponseEntity<?>  getallPosts()
		{
			
			List<PostGallery> allpo = postgalserv.getAllList();
			
			return ResponseEntity.ok().body(allpo);
		}
		
		@GetMapping("/allpostsummary")
		public ResponseEntity<?>  getallsumPosts()
		{
			
			List<PostGallresp> allpo = postgalserv.gelalllgalPosts();
			
			return ResponseEntity.ok().body(allpo);
		}
		
		@GetMapping("/myposts")
		public ResponseEntity<?>  getMyposts(@CurrentUser UserPrincipal me)
		{
			List<PostGallery> mis = postgalserv.MyPosts(me);
			return ResponseEntity.ok().body(mis);
		}

}
