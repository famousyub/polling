package com.example.polls.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.polls.model.Contactus;

import com.example.polls.payload.ContacRequest;

import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.ContactusService;

@RestController
@RequestMapping("/api/contact")
public class ContactusController {
	
	@Autowired
	ContactusService cs;
	
	@PostMapping("/sendcontact")
	public ResponseEntity<?> createPosts(@CurrentUser UserPrincipal me ,@Valid @RequestBody ContacRequest poreq){
		
		Contactus p = cs.sendContact(me, poreq);
		
		return ResponseEntity.ok().body(p);
		
	}
	
	@GetMapping("/allcontacts")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?>  getallPosts()
	{
		
		List<Contactus> allpo = cs.getAllContact();
		
		return ResponseEntity.ok().body(allpo);
	}

}
