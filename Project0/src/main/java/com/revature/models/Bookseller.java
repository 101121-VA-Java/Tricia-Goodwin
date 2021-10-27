package com.revature.models;

public class Bookseller extends User {

	//private static final Role ADMIN = null;

	public Bookseller(String username, String password) {
		super(username, password);
		this.setRole("ADMIN");
		numOfUsers++;
		this.setId(12345+numOfUsers);
	}
	
	

}
