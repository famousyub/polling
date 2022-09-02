package com.example.polls.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.exception.ResourceNotFoundException;
import com.example.polls.model.EditText;
import com.example.polls.model.Post;
import com.example.polls.model.User;
import com.example.polls.payload.EditTextRequest;
import com.example.polls.payload.PostRequest;
import com.example.polls.repository.PostsRepository;
import com.example.polls.repository.TextEditorRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;

@Service
public class TextEditorService {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	TextEditorRepository postsrepo;
	
	public EditText createPost( UserPrincipal currentUser, EditTextRequest postreq)
	{
		String username =currentUser.getUsername();
		 User user = userrepo.findByUsername(currentUser.getUsername())
	                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		
		 
		
			 EditText p = new EditText();
			 p.setContent(postreq.getContent());
			 p.setUserNumber(1);
			 p.setUser(user);
			 return postsrepo.save(p);
			 
			 
			 
			 
			 
		
		 
		
	
	}
	
	public List<EditText>  getAllList()
	{
		
		return postsrepo.findAll();
		
		
		
		
		
	}
	
	public List<EditText> MyPosts (UserPrincipal currentUser)
	{
		List<EditText> myposts = new ArrayList<>();
		
		List<EditText> allposts  = postsrepo.findAll();
		
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
