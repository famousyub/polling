package com.example.polls.service;
//https://github.com/SomnathDas/nLog/tree/main/server
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;

import com.example.polls.model.PostInfo;
import com.example.polls.model.User;
import com.example.polls.payload.PostInfoRequest;

import com.example.polls.repository.PostInfoRepository;

import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class PostInfoService {
	
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	PostInfoRepository postsrepo;
	
	public PostInfo createPost( UserPrincipal currentUser, PostInfoRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userrepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		
			 PostInfo p = new PostInfo();
			 p.setContent(postreq.getContent());
			 p.setInfocontent(postreq.getInfocontent());
			 p.setPostype(postreq.getPostype());
			 p.setUser(user);
			 return postsrepo.save(p);
			 
			 
			 
			 
			 
		
		 
		
	
	}
	
	public List<PostInfo>  getAllList()
	{
		
		return postsrepo.getAllpostsInfo();
		
		
		
		
		
	}
	
	public List<PostInfo> MyPosts (UserPrincipal currentUser)
	{
		List<PostInfo> myposts = new ArrayList<>();
		
		List<PostInfo> allposts  = postsrepo.findAll();
		
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
