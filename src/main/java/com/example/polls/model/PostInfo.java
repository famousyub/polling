package com.example.polls.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.polls.model.audit.UserDateAudit;

@Entity
@Table(name = "postinfo")
public class PostInfo extends UserDateAudit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    
    private String postype;

    @Column(columnDefinition="TEXT")
    @NotBlank
    @Size(max = 140)
    private String content;
    
    
    @Column(columnDefinition="TEXT")
    @NotBlank
    @Size(max = 140)
    private String infocontent;


	public PostInfo(Long id, User user, String postype, @NotBlank @Size(max = 140) String content,
			@NotBlank @Size(max = 140) String infocontent) {
		super();
		this.id = id;
		this.user = user;
		this.postype = postype;
		this.content = content;
		this.infocontent = infocontent;
	}


	public PostInfo() {
		super();
	}


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


	public String getPostype() {
		return postype;
	}


	public void setPostype(String postype) {
		this.postype = postype;
	}


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
    
    
    
    


}
