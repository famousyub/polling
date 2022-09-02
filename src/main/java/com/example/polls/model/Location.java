package com.example.polls.model;

import java.io.Serializable;

public class Location implements Serializable{
	
	private Long longitude ;
	private Long latitude ;
	public Location(Long longitude, Long latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	
	

}
