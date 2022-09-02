package com.example.polls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.Freind;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.FreindService;

@RestController
@RequestMapping("/api/friend")
public class FreindController {

	
	@Autowired
	FreindService freind ;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> savefreindList(@CurrentUser UserPrincipal me,@RequestParam("username") String usrname)
	{
		
		
		Freind gh =freind.saveFreind(me, usrname);
		
		return ResponseEntity.ok().body(gh);
	}
}
