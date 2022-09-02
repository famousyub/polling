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
@Table(name="sites")
public class Sites extends UserDateAudit {
	
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
    
    private String sitename;
    
    private String siteUrl ;
    
    @Column(name="isopen",columnDefinition = "Integer default 1")
    private Integer isopen ;
    
    @Column(name="siteuser",columnDefinition = "boolean default 1")
    private Boolean siteuser;

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

	public String getSitename() {
		return sitename;
	}

	public void setSitename(String sitename) {
		this.sitename = sitename;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public Integer getIsopen() {
		return isopen;
	}

	public void setIsopen(Integer isopen) {
		this.isopen = isopen;
	}

	public Boolean getSiteuser() {
		return siteuser;
	}

	public void setSiteuser(Boolean siteuser) {
		this.siteuser = siteuser;
	}

	public Sites(Long id, User user, @NotBlank @Size(max = 140) String content, String sitename, String siteUrl,
			Integer isopen, Boolean siteuser) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.sitename = sitename;
		this.siteUrl = siteUrl;
		this.isopen = isopen;
		this.siteuser = siteuser;
	}

	public Sites() {
		super();
	}
    
    

}
