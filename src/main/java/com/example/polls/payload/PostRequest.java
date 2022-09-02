package com.example.polls.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostRequest {
	
	
	 @NotBlank
	 @Size(max = 140)
	 private String content;
 
	 
	private Boolean commentable ;
	
	public Boolean getCommentable() {
		return commentable;
	}

	public void setCommentable(Boolean commentable) {
		this.commentable = commentable;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PostRequest(@NotBlank @Size(max = 140) String content) {
		super();
		this.content = content;
	}

	public PostRequest() {
		super();
	}

	
}
