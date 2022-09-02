package com.example.polls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Gameuser;
import com.example.polls.model.Post;
import com.example.polls.model.User;
import com.example.polls.payload.GameCreatorRequest;
import com.example.polls.payload.PostRequest;
import com.example.polls.property.UserRedisProperty;
import com.example.polls.repository.GameUserRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class GameService {
	
	@Autowired
	UserRepository userrepo ;
	
	
	@Autowired
	GameUserRepository gmrepo;
	
	
	public Gameuser createPost( UserPrincipal currentUser, GameCreatorRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userrepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		
			 Gameuser p = new Gameuser();
			 p.setScore(0);
			 p.setLevel(0);
			 p.setContent(postreq.getContent());
			 p.setGameLink(postreq.getGameLink());
			 p.setUser(user);
			 p.setGamedescription(postreq.getGamedescription());
			 return gmrepo.save(p);
			 
			 
			 
			 
			 
		
		 
		
	
	}
	
	public List<Gameuser> getAllGames(){
		 return gmrepo.findAll();
	}
	
	
	

}
