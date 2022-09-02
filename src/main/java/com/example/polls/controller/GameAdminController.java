package com.example.polls.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.Gameuser;
import com.example.polls.payload.GameCreatorRequest;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.GameService;

@RestController
@RequestMapping("/api/gadmin")
public class GameAdminController {

	
	@Autowired
	GameService gserv ;
	
	
	@PostMapping("/adcr")
	public ResponseEntity<?> createGame(@CurrentUser UserPrincipal me , @RequestBody GameCreatorRequest gc)
	{
		Gameuser io_ = gserv.createPost(me, gc);
		return ResponseEntity.ok().body(io_);
	}
	
	@GetMapping("/allgames")
	public ResponseEntity<?>  allgames()
	{
		List<Gameuser> gamesu= gserv.getAllGames();
		
		  return ResponseEntity.ok().body(gamesu);
	}
}
