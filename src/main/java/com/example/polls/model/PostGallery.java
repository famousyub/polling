package com.example.polls.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.polls.model.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "postgallery")
public class PostGallery extends UserDateAudit {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @Column(columnDefinition="TEXT")
    @NotBlank
    @Size(max = 140)
    private String content;
    
    
    @Lob
    @Column(name = "postpic", columnDefinition="LONGBLOB",nullable = true,length = 200000)
    private  byte[] postpic;


	public PostGallery(Long id, User user, @NotBlank @Size(max = 140) String content, byte[] postpic) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.postpic = postpic;
	}


	public PostGallery(User user, @NotBlank @Size(max = 140) String content, byte[] postpic) {
		super();
		this.user = user;
		this.content = content;
		this.postpic = postpic;
	}


	public PostGallery() {
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


	public byte[] getPostpic() {
		return postpic;
	}


	public void setPostpic(byte[] postpic) {
		this.postpic = postpic;
	}
    
    
    
    
}
