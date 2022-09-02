package com.example.polls.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.polls.model.audit.UserDateAudit;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post extends UserDateAudit  {

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

    @Column(columnDefinition="TEXT")
    @NotBlank
    @Size(max = 140)
    private String content;
    
    @Column(name = "commentable",columnDefinition = "boolean default 1",nullable = true)
    private Boolean isCommentable;
    
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Collection<CommentPost> comments;
    
    
    @OneToMany(mappedBy = "likepost", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Collection<LikePost> likes;

    public Post(Long id, User user, @NotBlank @Size(max = 140) String content, Boolean isCommentable,
			Collection<CommentPost> comments, Collection<LikePost> likes, Date createdDate) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.isCommentable = isCommentable;
		this.comments = comments;
		this.likes = likes;
		this.createdDate = createdDate;
	}



	public Collection<LikePost> getLikes() {
		return likes;
	}



	public void setLikes(Collection<LikePost> likes) {
		this.likes = likes;
	}



	public User getUser() {
		return user;
	}

	

	public Boolean getIsCommentable() {
		return isCommentable;
	}



	public void setIsCommentable(Boolean isCommentable) {
		this.isCommentable = isCommentable;
	}



	public Post(User user,@NotBlank @Size(max = 140)  String content, Date createdDate) {
		super();
		this.user = user;
		this.content = content;
		this.createdDate = createdDate;
	}

	public Post(Long id, User user,@NotBlank @Size(max = 140)  String content, Date createdDate) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.createdDate = createdDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }



	public Post(@NotBlank @Size(max = 140) String content) {
		super();
		this.content = content;
	}



	public Collection<CommentPost> getComments() {
		return comments;
	}



	public void setComments(Collection<CommentPost> comments) {
		this.comments = comments;
	}



	public Post(User user, @NotBlank @Size(max = 140) String content) {
		super();
		this.user = user;
		this.content = content;
	}



	public Post(Long id, User user, @NotBlank @Size(max = 140) String content, Boolean isCommentable,
			Collection<CommentPost> comments, Date createdDate) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.isCommentable = isCommentable;
		this.comments = comments;
		this.createdDate = createdDate;
	}



	
    
}
