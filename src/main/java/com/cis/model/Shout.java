package com.cis.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

//@Entity
public class Shout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;	

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
	User shouter;
    
    @JoinColumn()
    User actionTaker;
    
    @JoinColumn(name = "categoryid")
    Category category;
    
    String shoutmessage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getShouter() {
		return shouter;
	}

	public void setShouter(User shouter) {
		this.shouter = shouter;
	}

	public User getActionTaker() {
		return actionTaker;
	}

	public void setActionTaker(User actionTaker) {
		this.actionTaker = actionTaker;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getShoutmessage() {
		return shoutmessage;
	}

	public void setShoutmessage(String shoutmessage) {
		this.shoutmessage = shoutmessage;
	}

	public Shout(long id, User shouter, User actionTaker, Category category, String shoutmessage) {
		super();
		this.id = id;
		this.shouter = shouter;
		this.actionTaker = actionTaker;
		this.category = category;
		this.shoutmessage = shoutmessage;
	}
    
	
}
