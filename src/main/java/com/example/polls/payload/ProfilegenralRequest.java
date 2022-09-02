package com.example.polls.payload;

import java.util.Date;

import javax.validation.constraints.Size;

import com.example.polls.model.Gender;

public class ProfilegenralRequest {
	
	
	
	@Size(max = 15)
    private String phoneNumber;
	
	
	 private String first_name;
	 
	 private String last_name;
	 
	 private String about ;
	 
	 private Date dateOfBirth;
	 
	 
	 private String hobbies;
	 
	 private Gender gender;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	 
	 

}
