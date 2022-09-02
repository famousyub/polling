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
@Table(name = "contactus")
public class Contactus extends UserDateAudit {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    
    @Column(columnDefinition="varchar(255)")
    @NotBlank
    @Size(max = 140)
    private String probleme;
    
    @Column(columnDefinition="TEXT")
    @NotBlank
    @Size(max = 140)
    private String description;

    @Column(columnDefinition="TEXT")
    @NotBlank
    @Size(max = 140)
    private String content;

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

	public String getProbleme() {
		return probleme;
	}

	public void setProbleme(String probleme) {
		this.probleme = probleme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Contactus(Long id, User user, @NotBlank @Size(max = 140) String probleme,
			@NotBlank @Size(max = 140) String description, @NotBlank @Size(max = 140) String content) {
		super();
		this.id = id;
		this.user = user;
		this.probleme = probleme;
		this.description = description;
		this.content = content;
	}

	public Contactus() {
		super();
	}

	public Contactus(User user, @NotBlank @Size(max = 140) String probleme,
			@NotBlank @Size(max = 140) String description, @NotBlank @Size(max = 140) String content) {
		super();
		this.user = user;
		this.probleme = probleme;
		this.description = description;
		this.content = content;
	}
    
    

}
