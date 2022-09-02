package com.example.polls.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.EditText;
import com.example.polls.model.Post;
import com.example.polls.payload.EditTextRequest;
import com.example.polls.payload.PostRequest;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.TextEditorService;

@RestController
@RequestMapping("/api/edittext")
public class EditTextController {
	
	@Autowired
	TextEditorService textservice ;
	
	
	@PostMapping("/textcreate")
	public ResponseEntity<?> createPosts(@CurrentUser UserPrincipal me ,@Valid @RequestBody EditTextRequest poreq){
		
		EditText p = textservice.createPost(me, poreq);
		
		return ResponseEntity.ok().body(p);
		
	}
	
	@GetMapping("/allposts")
	public ResponseEntity<?>  getallPosts()
	{
		
		List<EditText> allpo = textservice.getAllList();
		
		return ResponseEntity.ok().body(allpo);
	}
	
	@GetMapping("/myposts")
	public ResponseEntity<?>  getMyposts(@CurrentUser UserPrincipal me)
	{
		List<EditText> mis = textservice.MyPosts(me);
		return ResponseEntity.ok().body(mis);
	}


}
