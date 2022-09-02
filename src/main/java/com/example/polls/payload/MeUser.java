package com.example.polls.payload;

public class MeUser {
	
	
	private Long meid;
	
	public Long getMeid() {
		return meid;
	}
	public void setMeid(Long meid) {
		this.meid = meid;
	}
	private String username ;
	private String email;
	private Integer age;
	private String Name ;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
