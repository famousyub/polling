package com.example.polls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.CommentPost;
import com.example.polls.model.Post;
import com.example.polls.model.User;
import com.example.polls.payload.CommentPostRequest;
import com.example.polls.payload.PostRequest;
import com.example.polls.repository.CommentPostRepository;
import com.example.polls.repository.PostsRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class CommentPostService {
	
	@Autowired
	CommentPostRepository postcommrepo;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	PostsRepository postrep;
	
	public CommentPost createPost( UserPrincipal currentUser, CommentPostRequest postreq,Long postId)
	{
		String username =currentUser.getUsername();
		 User user = userrepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		 
		 Post g = postrep.getById(postId);
		 
		 
		
		 CommentPost p = new CommentPost();
			p.setBody(postreq.getBody());
			 p.setPost(g);
			 p.setUser(user);
			 return postcommrepo.save(p);
			 
			 
			 
			 
			 
		
		 
		
	
	}
	
	public List<CommentPost>  getAllList()
	{
		
		return postcommrepo.findAll();
		
		
		
		
		
	}
	
	public List<CommentPost> MyPosts (UserPrincipal currentUser)
	{
		List<CommentPost> myposts = new ArrayList<>();
		
		List<CommentPost> allposts  = postcommrepo.findAll();
		
	//	if(!allposts.isEmpty()) {
			
			allposts.forEach(po ->{
				  if(po.getUser().getId().equals(currentUser.getId() )) {
					  System.out.println(po.getBody());
					  myposts.add(po);
					   
				  }
			});
			
			return myposts;
			
		//}
		//return myposts;
	}


}
