package com.example.polls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Post;
import com.example.polls.model.User;
import com.example.polls.payload.PostRequest;
import com.example.polls.repository.PostsRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;
@Service
public class PostsService {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	PostsRepository postsrepo;
	
	public Post createPost( UserPrincipal currentUser, PostRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userrepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		
			 Post p = new Post();
			 p.setIsCommentable(true);
			 p.setContent(postreq.getContent());
			 p.setUser(user);
			 return postsrepo.save(p);
			 
			 
			 
			 
			 
		
		 
		
	
	}
	
	public List<Post>  getAllList()
	{
		
		return postsrepo.getAllposts();
		
		
		
		
		
	}
	
	public List<Post> MyPosts (UserPrincipal currentUser)
	{
		List<Post> myposts = new ArrayList<>();
		
		List<Post> allposts  = postsrepo.findAll();
		
	//	if(!allposts.isEmpty()) {
			
			allposts.forEach(po ->{
				  if(po.getUser().getId().equals(currentUser.getId() )) {
					  System.out.println(po.getContent());
					  myposts.add(po);
					   
				  }
			});
			
			return myposts;
			
		//}
		//return myposts;
	}

}
