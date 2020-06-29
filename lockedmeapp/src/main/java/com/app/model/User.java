package com.app.model;

public class User {
	private String name;
	private String contents;
	//private String username;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}

	public User(String name, String contents) {
		super();
		this.name = name;
		this.contents = contents;
		
	}
	

	public User(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", contents=" + contents + "]";
	}
	
	
	
	
	
}
