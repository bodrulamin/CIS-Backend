package com.cis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@Column(unique = true,nullable = false)
	String name;
	
	long shoutcount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getShoutcount() {
		return shoutcount;
	}

	public void setShoutcount(long shoutcount) {
		this.shoutcount = shoutcount;
	}

	public Category(long id, String name, long shoutcount) {
		super();
		this.id = id;
		this.name = name;
		this.shoutcount = shoutcount;
	}


	
	
	
	
}
