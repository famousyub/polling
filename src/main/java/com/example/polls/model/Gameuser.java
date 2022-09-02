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

import com.example.polls.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "gameuser")
public class Gameuser extends DateAudit {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(columnDefinition="TEXT")
    @NotBlank
    @Size(max = 140)
    private String content;
    
    
    private String GameLink;
    
    private Integer score = 0;
    private Integer level = 0;
    
    private String gamedescription ;

	public Gameuser(Long id, User user, @NotBlank @Size(max = 140) String content, String gameLink, Integer score,
			Integer level, String gamedescription) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		GameLink = gameLink;
		this.score = score;
		this.level = level;
		this.gamedescription = gamedescription;
	}

	public Gameuser(User user, @NotBlank @Size(max = 140) String content, String gameLink, Integer score, Integer level,
			String gamedescription) {
		super();
		this.user = user;
		this.content = content;
		GameLink = gameLink;
		this.score = score;
		this.level = level;
		this.gamedescription = gamedescription;
	}

	public Gameuser() {
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

	public String getGameLink() {
		return GameLink;
	}

	public void setGameLink(String gameLink) {
		GameLink = gameLink;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getGamedescription() {
		return gamedescription;
	}

	public void setGamedescription(String gamedescription) {
		this.gamedescription = gamedescription;
	}
    
    private void incrementscore(int a) {
    	 this.score += a;
    }
    
    private void levelup() 
    {
      this.level++;	
    }
}
