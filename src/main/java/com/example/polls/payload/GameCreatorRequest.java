package com.example.polls.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GameCreatorRequest {
	
	
    @NotBlank
    @Size(max = 140)
    private String content;
    
    
    private String GameLink;
    
    
    private String gamedescription ;


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getGameLink() {
		return GameLink;
	}


	public void setGameLink(String gameLink) {
		GameLink = gameLink;
	}


	public String getGamedescription() {
		return gamedescription;
	}


	public void setGamedescription(String gamedescription) {
		this.gamedescription = gamedescription;
	}
    
    

}
