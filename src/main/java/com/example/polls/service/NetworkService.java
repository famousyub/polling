package com.example.polls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Networks;
import com.example.polls.model.User;
import com.example.polls.payload.NetworkRequest;
import com.example.polls.payload.PostRequest;
import com.example.polls.repository.NetworkRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class NetworkService {
	
	@Autowired
	NetworkRepository netrepo;
	
	@Autowired
	UserRepository  userepo;
	
	
	public Networks createNetworks(UserPrincipal currentUser, NetworkRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		Networks net_ = new Networks();
		net_.setNetworkdata(postreq.getNetworkdata());
		net_.setNetworkname(postreq.getNetworkname());
		
		net_.setNetworkstataus(200);
		
		net_.setUser(user);
		return netrepo.save(net_);
		
		
		
		
		
	}

}
