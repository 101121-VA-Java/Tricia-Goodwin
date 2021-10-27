package com.revature.models;

public class User {
	
	private int id;
	private String username;
	//private Role role;
	private String role;
	private String password;
	protected static int numOfUsers;
	
	
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
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}
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
	//	public User(String username,String role, String password) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.role = role;
//		numOfUsers++;
//		this.id = 12345+numOfUsers;
//		
//	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

	

}
