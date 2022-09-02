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

import com.example.polls.model.audit.UserDateAudit;

@Entity
@Table(name="networks")
public class Networks extends UserDateAudit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    private String networkname;
    private String networkdata;
    
    @Column(name="networkstataus",columnDefinition = "Integer default 200")
    private Integer networkstataus;

	public Networks(Long id, User user, String networkname, String networkdata, Integer networkstataus) {
		super();
		this.id = id;
		this.user = user;
		this.networkname = networkname;
		this.networkdata = networkdata;
		this.networkstataus = networkstataus;
	}

	public Networks() {
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

	public String getNetworkname() {
		return networkname;
	}

	public void setNetworkname(String networkname) {
		this.networkname = networkname;
	}

	public String getNetworkdata() {
		return networkdata;
	}

	public void setNetworkdata(String networkdata) {
		this.networkdata = networkdata;
	}

	public Integer getNetworkstataus() {
		return networkstataus;
	}

	public void setNetworkstataus(Integer networkstataus) {
		this.networkstataus = networkstataus;
	}
    
    
    

}
