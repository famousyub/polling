package com.example.polls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Post;
import com.example.polls.model.User;
import com.example.polls.model.UserProfile;
import com.example.polls.payload.PostRequest;
import com.example.polls.payload.ProfilePicRequest;
import com.example.polls.payload.ProfileextrRequest;
import com.example.polls.payload.ProfilegenralRequest;
import com.example.polls.repository.UserProfileRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class MyProfileService {
	
	
	@Autowired
	UserRepository userrepo ;
	@Autowired 
	UserProfileRepository usreprof;
	
	
	
	public UserProfile createProfilepic( UserPrincipal currentUser, ProfilePicRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userrepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		 UserProfile  userpr = new UserProfile();
		 
		 userpr.setUser(user);
		 user.setUserProfile(userpr);
		 userpr.setProfile_picture(postreq.getProfile_picture());
		 
		   userrepo.save(user);
		   
		   return userpr;
	}
	
	public UserProfile createextrProfilepic( UserPrincipal currentUser, ProfileextrRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userrepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		 UserProfile  userpr = new UserProfile();
		 
		 userpr.setUser(user);
		// userpr.setId(user.getId());
		 userpr.setAddress1(postreq.getAddress1());
		 userpr.setAddress2(postreq.getAddress2());
		 userpr.setCity(postreq.getCity());
		 userpr.setStreet(postreq.getStreet());
		 userpr.setCountry(postreq.getCountry());
		 userpr.setZipCode(postreq.getZipCode());
		 userpr.setState(postreq.getState());
		 
		 return  usreprof.save(userpr);
	}
	
	public UserProfile creatgeneralrProfilepic( UserPrincipal currentUser, ProfilegenralRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userrepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		 UserProfile  userpr = new UserProfile();
		// userpr.setId(user.getId());
		 userpr.setUser(user);
		 userpr.setFirst_name(postreq.getFirst_name());
		 userpr.setLast_name(postreq.getLast_name());
		 userpr.setAbout(postreq.getAbout());
		 userpr.setGender(postreq.getGender());
		 userpr.setHobbies(postreq.getHobbies());
		 userpr.setDateOfBirth(postreq.getDateOfBirth());
		 
		 user.setUserProfile(userpr);
		 
		 
		 
		 
		 
		 
		 return  usreprof.save(userpr);
	}
	

}
