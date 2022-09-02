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

import javax.validation.constraints.NotNull;

import com.example.polls.model.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name = "likepost")
public class LikePost extends UserDateAudit {
	
	
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
    
    
    @NotNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post likepost;
    
    @Column(columnDefinition = "Integer", nullable = false)
    
    private Integer numberlikes;
    
    private Boolean likeby;
    private Boolean isLiked;
	public LikePost(Long id, User user, @NotNull Post post, Integer numberlikes, Boolean likeby, Boolean isLiked) {
		super();
		this.id = id;
		this.user = user;
		this.likepost = post;
		this.numberlikes = numberlikes;
		this.likeby = likeby;
		this.isLiked = isLiked;
	}
	public LikePost() {
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
	
	public Post getLikepost() {
		return likepost;
	}
	public void setLikepost(Post likepost) {
		this.likepost = likepost;
	}
	public Integer getNumberlikes() {
		return numberlikes;
	}
	public void setNumberlikes(Integer numberlikes) {
		this.numberlikes = numberlikes;
	}
	public Boolean getLikeby() {
		return likeby;
	}
	public void setLikeby(Boolean likeby) {
		this.likeby = likeby;
	}
	public Boolean getIsLiked() {
		return isLiked;
	}
	public void setIsLiked(Boolean isLiked) {
		this.isLiked = isLiked;
	}
    
    public int incrementLikes() {
    return 	this.numberlikes++;
    }
    
    
    public Boolean isLikedBy(Long id,Long userId) {
    	return userId == id;
    }
    
    public int removeLikes() {
    	
    		 return this.numberlikes--;
    	
    }

}
