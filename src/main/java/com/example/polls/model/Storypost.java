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
@Table(name="storypost")
public class Storypost extends UserDateAudit {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(columnDefinition="TEXT")
    @NotBlank
    @Size(max = 140)
    private String content;
    
    @Column(columnDefinition = "varchar(255)")
    private String strorylink;

	public Storypost(Long id, User user, @NotBlank @Size(max = 140) String content, String strorylink) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.strorylink = strorylink;
	}

	public Storypost() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStrorylink() {
		return strorylink;
	}

	public void setStrorylink(String strorylink) {
		this.strorylink = strorylink;
	}
    
    
    

}
