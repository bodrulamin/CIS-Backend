package com.cis.model;

public class Ruser {
	long id;
	String fullname;
	String username;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Ruser(long id, String fullname, String username) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
	}
	public Ruser() {
		super();
	}

}
