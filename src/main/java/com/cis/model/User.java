package com.cis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@Column(unique = true)
	String username;
	String fullname;
	String password;
	String email;
	String phone;
	String address;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(long id, String username, String fullname, String password) {
		super();
		this.id = id;

		this.username = username;
		this.fullname = fullname;
		this.password = password;
	}

}
