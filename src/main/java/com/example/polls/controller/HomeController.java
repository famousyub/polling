package com.example.polls.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {
  
	
	 @GetMapping("/")
	 public ResponseEntity<?> getHello(){
		 
		  return ResponseEntity.ok().body("hello infity users");
	 }
}
