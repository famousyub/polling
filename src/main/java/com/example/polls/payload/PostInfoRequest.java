package com.example.polls.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostInfoRequest {
	
	 @NotBlank
	 @Size(max = 140)
	 private String content;
	 
	 @NotBlank
	 @Size(max = 140)
	 private String infocontent;
	 
	 private String postype;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInfocontent() {
		return infocontent;
	}

	public void setInfocontent(String infocontent) {
		this.infocontent = infocontent;
	}

	public String getPostype() {
		return postype;
	}

	public void setPostype(String postype) {
		this.postype = postype;
	}
	 
	 

}
