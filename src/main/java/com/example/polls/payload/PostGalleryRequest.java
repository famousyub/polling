package com.example.polls.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostGalleryRequest {
	
	 @NotBlank
	 @Size(max = 140)
	 private String content;
	 
	 
	 private byte[] postpic ;


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public byte[] getPostpic() {
		return postpic;
	}


	public void setPostpic(byte[] postpic) {
		this.postpic = postpic;
	}
	 
	 

}
