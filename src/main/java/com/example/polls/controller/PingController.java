package com.example.polls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.User;
import com.example.polls.payload.MeUser;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;

@RestController
@RequestMapping("/api/pings")
public class PingController {
	
	@Autowired
	UserRepository merepo;
	@GetMapping("/")
	public ResponseEntity<?> getPing()
	{
		
		  String hell="hello threre";
		  
		  return ResponseEntity.ok().body(hell);
	}
	
	
	@GetMapping("/currentuser")
	public ResponseEntity<?> getCurentUser(@CurrentUser UserPrincipal me)
	
	{
		String username =me.getUsername();
		 User user = merepo.findByUsername(me.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		 MeUser me_ = new MeUser();
		 me_.setAge(user.getAge());
		 me_.setMeid(user.getId());
		 me_.setUsername(username);
		 me_.setEmail(user.getEmail());
		 me_.setName(user.getName());
		 
		 
		 return ResponseEntity.ok().body(me_);
		 
	}

}
