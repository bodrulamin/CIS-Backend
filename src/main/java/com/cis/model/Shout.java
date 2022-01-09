package com.cis.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Shout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;	

	long shouterId;
    
    long  actionTakerId;
    
    long categoryId;
    
    String shoutmessage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getShouterId() {
		return shouterId;
	}

	public void setShouterId(long shouterId) {
		this.shouterId = shouterId;
	}

	public long getActionTakerId() {
		return actionTakerId;
	}

	public void setActionTakerId(long actionTakerId) {
		this.actionTakerId = actionTakerId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getShoutmessage() {
		return shoutmessage;
	}

	public void setShoutmessage(String shoutmessage) {
		this.shoutmessage = shoutmessage;
	}

	public Shout(long id, long shouterId, long actionTakerId, long categoryId, String shoutmessage) {
		super();
		this.id = id;
		this.shouterId = shouterId;
		this.actionTakerId = actionTakerId;
		this.categoryId = categoryId;
		this.shoutmessage = shoutmessage;
	}

	public Shout() {
		super();
	}

	
}
