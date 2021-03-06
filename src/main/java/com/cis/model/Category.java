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
	
	@Column(unique = true, nullable = false)
	String name;
	
	  
 	
	public Category() {
	 
	}

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

	public Category(long id, String name) {
 		this.id = id;
		this.name = name;
	}
	
}
