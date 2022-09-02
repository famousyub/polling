package com.example.polls.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.polls.model.audit.UserDateAudit;

@Entity
@Table(name="restaurants")
public class Restaurants  extends UserDateAudit{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    
    
    private String restoname;
    private String restotype;
    
    private String restourl;
    private String restoimage;
    
    private Location location ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRestoname() {
		return restoname;
	}

	public void setRestoname(String restoname) {
		this.restoname = restoname;
	}

	public String getRestotype() {
		return restotype;
	}

	public void setRestotype(String restotype) {
		this.restotype = restotype;
	}

	public String getRestourl() {
		return restourl;
	}

	public void setRestourl(String restourl) {
		this.restourl = restourl;
	}

	public String getRestoimage() {
		return restoimage;
	}

	public void setRestoimage(String restoimage) {
		this.restoimage = restoimage;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Restaurants(Long id, User user, String restoname, String restotype, String restourl, String restoimage,
			Location location) {
		super();
		this.id = id;
		this.user = user;
		this.restoname = restoname;
		this.restotype = restotype;
		this.restourl = restourl;
		this.restoimage = restoimage;
		this.location = location;
	}

	public Restaurants() {
		super();
	}
    
    
    
    

}
