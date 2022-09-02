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
@Table(name = "edittext")
public class EditText  extends UserDateAudit{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(columnDefinition="TEXT")
    @NotBlank
    @Size(max = 5000)
    private String content;
    
    
    @Column(name = "user_number")
    private Integer userNumber ;


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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getUserNumber() {
		return userNumber;
	}


	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}


	public EditText(Long id, User user, @NotBlank @Size(max = 5000) String content, Integer userNumber) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.userNumber = userNumber;
	}


	public EditText() {
		super();
	}
    
	
	public void  numberUpdat()
	{
		 this.userNumber++;
	}
    

}
