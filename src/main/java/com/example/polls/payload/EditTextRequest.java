package com.example.polls.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EditTextRequest {
	
	 @NotBlank
	 @Size(max =5000)
	 private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	 
	 
	 
  
}
