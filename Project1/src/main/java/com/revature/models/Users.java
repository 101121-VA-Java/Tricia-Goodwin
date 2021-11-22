package com.revature.models;



 

public class Users {
	private int ID;

	private String username;
	private String password;
	private String fname;
	private String lname;
	private String email;
	private Role role;
	
	public Users() {
		super();
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Users(String username, String password, String fname, String lname, String email, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
	}
	public Users(int ID,String username, String password, String fname, String lname, String email, Role role) {
		super();
		this.ID = ID;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Users [fname=" + fname + ", lname=" + lname + ", username=" + username + ", email=" + email + ", role="
				+ role + "]";
	}
	
	

}
