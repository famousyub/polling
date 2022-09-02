package com.example.polls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Contactus;
import com.example.polls.model.User;
import com.example.polls.payload.ContacRequest;
import com.example.polls.repository.ContactusRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;


@Service
public class ContactusService {
	
	@Autowired
	ContactusRepository contrepo ;
	
	@Autowired 
	UserRepository userepo;
	
	public Contactus sendContact(UserPrincipal me , ContacRequest cr) {
		
		Contactus c = new Contactus();
		
		c.setContent(cr.getContent());
		c.setDescription(cr.getDescription());
		c.setProbleme(cr.getProbleme());
		String username =me.getUsername();
		 User user = userepo.findByUsername(me.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		c.setUser(user);
		return contrepo.save(c);
		  
	}

	
	public List<Contactus>  getAllContact()
	{
		
		 return contrepo.findAll();
	}
}
