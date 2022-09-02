package com.example.polls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.LikePost;
import com.example.polls.model.Post;
import com.example.polls.model.User;
import com.example.polls.payload.LikepostRequest;
import com.example.polls.repository.LikePostRepository;
import com.example.polls.repository.PostsRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class LikePostService {
	
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	LikePostRepository likrepo;
	@Autowired
	PostsRepository postrepo;
	
	public LikePost addLikesPost(UserPrincipal me , Long  p ,LikepostRequest li)
	{
		
		
		String username =me.getUsername();
		 User user = userrepo.findByUsername(me.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		 Post y = postrepo.findById(p).get();
		 
		 LikePost lp = new LikePost();
		 
//		 if(lp.getUser().equals(null)) {
//			 lp.incrementLikes();
//		 }
//		 else if(lp.isLikedBy(user.getId(),lp.getUser().getId())) {
//			 lp.removeLikes();
//			 
//			 
//		 }
//		 
//		 else {
//			
//		 }
		 lp.setNumberlikes(li.getNumberlikes());
		 //lp.incrementLikes();
		 lp.setLikeby(true);
		 lp.setLikeby(true);
		 lp.setUser(user);
		 lp.setLikepost(y);
		 return likrepo.save(lp);
		 
		 
		 
		 
	}

}
