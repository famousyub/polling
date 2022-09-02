package com.example.polls.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.polls.model.audit.UserDateAudit;

@Entity
@Table(name = "friends")
public class Freind extends UserDateAudit{
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "created_date")
	    private Date freinddDate;


	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "first_user_id", referencedColumnName = "id")
	    User firstUser;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "second_user_id", referencedColumnName = "id")
	    User secondUser;

		public Freind(Long id, Date freinddDate, User firstUser, User secondUser) {
			super();
			this.id = id;
			this.freinddDate = freinddDate;
			this.firstUser = firstUser;
			this.secondUser = secondUser;
		}

		public Freind() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getFreinddDate() {
			return freinddDate;
		}

		public void setFreinddDate(Date freinddDate) {
			this.freinddDate = freinddDate;
		}

		public User getFirstUser() {
			return firstUser;
		}

		public void setFirstUser(User firstUser) {
			this.firstUser = firstUser;
		}

		public User getSecondUser() {
			return secondUser;
		}

		public void setSecondUser(User secondUser) {
			this.secondUser = secondUser;
		}
	    
	    
	    

}
