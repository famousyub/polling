package com.example.polls.payload;

import java.time.Instant;
import java.util.Date;

public class PostGallresp {
	
	private String content  ;
	
	private byte[] pic ;
	
	private Instant createdAt ;
	
	private UserSummary meoroser;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public UserSummary getMeoroser() {
		return meoroser;
	}

	public void setMeoroser(UserSummary meoroser) {
		this.meoroser = meoroser;
	}

	public PostGallresp() {
		super();
	}
	
	
	

}
