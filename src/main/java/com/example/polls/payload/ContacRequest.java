package com.example.polls.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ContacRequest {
	
	 @NotBlank
	 @Size(max = 140)
	 private String content;
	
	@NotBlank
	 @Size(max = 140)
	 private String description;
	
	
	 @NotBlank
	 @Size(max = 140)
	 private String probleme;


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getProbleme() {
		return probleme;
	}


	public void setProbleme(String probleme) {
		this.probleme = probleme;
	}
	
	

}
