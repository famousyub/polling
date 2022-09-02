package com.example.polls.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.example.polls.model.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="userprofile")
public class UserProfile extends UserDateAudit {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "phone_number")
	    @Size(max = 15)
	    private String phoneNumber;
	    
	    @Column(name="first_name")
	    private String first_name;
	    @Column(name="last_name")
	    private String last_name;
	    @Column(columnDefinition="TEXT")
	    private String about ;
	    

	    @Enumerated(EnumType.STRING)
	    @Column(length = 10)
	    private Gender gender;

	    @Temporal(TemporalType.DATE)
	    @JsonFormat(pattern="yyyy-MM-dd")
	    @Column(name = "dob")
	    private Date dateOfBirth;
	    
	    @Size(min=2,max=50)
	    private String hobbies;
	    
	    @Lob
	    @Column(name = "profile_picture", columnDefinition="longblob",nullable = true)
	    private byte [] profile_picture;
	    
	    @Lob
	    @Column(name = "profile_cover", columnDefinition="longblob",nullable = true)
	    private byte[] profile_cover;
	    

	    @Size(max = 100)
	    private String address1;

	    @Size(max = 100)
	    private String address2;

	    @Size(max = 100)
	    private String street;

	    @Size(max = 100)
	    private String city;

	    @Size(max = 100)
	    private String state;

	    @Size(max = 100)
	    private String country;

	    @Column(name = "zip_code")
	    @Size(max = 32)
	    private String zipCode;

	    @OneToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
	    @JsonIgnore
	    private User user;

		public UserProfile(Long id, @Size(max = 15) String phoneNumber, Gender gender, Date dateOfBirth,
				@Size(min = 2, max = 50) String hobbies, @Size(max = 100) String address1,
				@Size(max = 100) String address2, @Size(max = 100) String street, @Size(max = 100) String city,
				@Size(max = 100) String state, @Size(max = 100) String country, @Size(max = 32) String zipCode,
				User user) {
			super();
			this.id = id;
			this.phoneNumber = phoneNumber;
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.hobbies = hobbies;
			this.address1 = address1;
			this.address2 = address2;
			this.street = street;
			this.city = city;
			this.state = state;
			this.country = country;
			this.zipCode = zipCode;
			this.user = user;
		}

		public UserProfile(@Size(max = 15) String phoneNumber, Gender gender, Date dateOfBirth,
				@Size(min = 2, max = 50) String hobbies, @Size(max = 100) String address1,
				@Size(max = 100) String address2, @Size(max = 100) String street, @Size(max = 100) String city,
				@Size(max = 100) String state, @Size(max = 100) String country, @Size(max = 32) String zipCode,
				User user) {
			super();
			this.phoneNumber = phoneNumber;
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.hobbies = hobbies;
			this.address1 = address1;
			this.address2 = address2;
			this.street = street;
			this.city = city;
			this.state = state;
			this.country = country;
			this.zipCode = zipCode;
			this.user = user;
		}

		public UserProfile() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
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

		public String getAddress1() {
			return address1;
		}

		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
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

		public byte[] getProfile_picture() {
			return profile_picture;
		}

		public void setProfile_picture(byte[] profile_picture) {
			this.profile_picture = profile_picture;
		}

		public byte[] getProfile_cover() {
			return profile_cover;
		}

		public void setProfile_cover(byte[] profile_cover) {
			this.profile_cover = profile_cover;
		}
	    
	    
	    

}
