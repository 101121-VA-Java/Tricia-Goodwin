package com.revature.models;

public class User {
	
	private String fname;
	private String lname;
	private int id;
	private String username;
	private String role;
	private String password;
	protected static int numOfUsers;
	
	
	
	
	public User(String fname, String lname, String username, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
		
		
		
	
	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	
@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", role=" + role + "]";
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

	

}
