package com.example.polls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.Post;
import com.example.polls.model.PostGallery;
import com.example.polls.model.User;
import com.example.polls.payload.PostGalleryRequest;
import com.example.polls.payload.PostGallresp;
import com.example.polls.payload.PostRequest;
import com.example.polls.payload.UserSummary;
import com.example.polls.repository.PostGalleryRepository;
import com.example.polls.repository.PostsRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class PostGalleryService {
	
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	PostGalleryRepository postsrepo;
	
	public PostGallery createPost( UserPrincipal currentUser, PostGalleryRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userrepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		
			 PostGallery p = new PostGallery();
			 p.setContent(postreq.getContent());
			 p.setPostpic(postreq.getPostpic());
			 p.setUser(user);
			 return postsrepo.save(p);
			 
			 
			 
			 
			 
		
		 
		
	
	}
	
	public List<PostGallery>  getAllList()
	{
		
		return postsrepo.findAll();
		
		
		
		
		
	}
	
	public List<PostGallresp> gelalllgalPosts(){
		
		  List <PostGallery> lo = postsrepo.findAll();
		  
		  List <PostGallresp> prs = new ArrayList<>();
		  PostGallresp pr_ =new PostGallresp() ;
		 ;
		  for ( PostGallery l : lo) {
			     pr_.setContent(l.getContent());
			     pr_.setPic(l.getPostpic());
			     pr_.setCreatedAt(l.getCreatedAt());
			     
			     UserSummary user_  = new UserSummary(l.getUser().getId(), l.getUser().getUsername(), l.getUser().getName());
			     
			     pr_.setMeoroser(user_);
			     
			     
			     prs.add(pr_);
			     
			     
			     
		  }
		  
		  return prs;
	}
	
	public List<PostGallery> MyPosts (UserPrincipal currentUser)
	{
		List<PostGallery> myposts = new ArrayList<>();
		
		List<PostGallery> allposts  = postsrepo.findAll();
		
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
