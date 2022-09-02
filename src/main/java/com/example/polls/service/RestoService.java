package com.example.polls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Restaurants;
import com.example.polls.model.User;
import com.example.polls.payload.PostRequest;
import com.example.polls.payload.RestoRequest;
import com.example.polls.repository.RestaurantRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class RestoService {
	
	@Autowired
	RestaurantRepository restorep;
	@Autowired
	UserRepository userepo;
	
	public Restaurants createResto(UserPrincipal currentUser, RestoRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		 Restaurants resto = new Restaurants();
		 
		 resto.setRestoimage(postreq.getRestoimage());
		 resto.setRestoname(postreq.getRestoname());
		 
		 resto.setRestourl(postreq.getRestourl());
		 
		 resto.setRestotype(postreq.getRestotype());
		 resto.setLocation(postreq.getLocation());
		 
		 resto.setUser(user);
		
		 
		 return restorep.save(resto);
		 	 
	}

}
