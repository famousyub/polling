package com.example.polls.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.model.UserProfile;
import com.example.polls.payload.ProfilePicRequest;
import com.example.polls.payload.ProfileextrRequest;
import com.example.polls.payload.ProfilegenralRequest;
import com.example.polls.security.CurrentUser;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.MyProfileService;

@RestController
@RequestMapping("/api/profile")
public class MyprofileController {
	
	@Autowired
	MyProfileService  profser ;
	
	private byte[] myimage =null ;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadme(@RequestParam("file") MultipartFile file) throws IOException
	{
		
		if(file.getSize()> 0   && file.getSize() < 50 *1024) {
			 myimage= file.getBytes();
			 
			 String resp =""; 
			 
			 Long  size_pic =  file.getSize();
			 
			 
			 String.format(resp, "uploaded image succesfully size %ld",size_pic);
			 
			 return ResponseEntity.ok().body(resp);
			 
			 
		}
		
		return ResponseEntity.ok().body("error  something wrong too big ");
	}
	
	@PutMapping("/me/update")
	public ResponseEntity<?> createPicprofile(@CurrentUser UserPrincipal me)
	{
		if(this.myimage != null) {
			
			ProfilePicRequest  re = new ProfilePicRequest();
			re.setProfile_picture(myimage);
			profser.createProfilepic(me, re);
			
			return ResponseEntity.ok().body("profile updated");
			 
		}
		
		return ResponseEntity.ok().body("error  something wrong");
		
	}
	
	@PutMapping("/me/extra")
	public ResponseEntity<?>  createextraprofile(@CurrentUser UserPrincipal me, @RequestBody ProfileextrRequest prextr)
	{
		
		UserProfile me_ = profser.createextrProfilepic(me, prextr);
		return ResponseEntity.ok().body(me_);
	}
	
	@PutMapping("/me/general")
	public ResponseEntity<?>  creategeneralraprofile(@CurrentUser UserPrincipal me, @RequestBody ProfilegenralRequest prextr)
	{
		
		UserProfile me_ = profser.creatgeneralrProfilepic(me, prextr);
		return ResponseEntity.ok().body(me_);
	}

}
