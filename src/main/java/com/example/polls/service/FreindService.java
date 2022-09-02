package com.example.polls.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Freind;
import com.example.polls.model.User;
import com.example.polls.repository.FreindRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class FreindService {
	
	 @Autowired
	    FreindRepository friendRepository;

	    @Autowired
	    UserRepository userRepository;
	    
	    
	    public Freind saveFreind(UserPrincipal me,String username)
	    {
	    	User user = userRepository.findByUsername(me.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", me.getUsername()));
	    	
	    	
	    	User user2 = userRepository.findByUsername(username)
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
	    	
	    	
	    	Freind fre = new Freind();
	    	
	    	fre.setFirstUser(user);
	    	fre.setSecondUser(user2);
	    	fre.setFreinddDate(new Date());
	    	
	    	return friendRepository.save(fre);
	    	
	    	
	    }


}
