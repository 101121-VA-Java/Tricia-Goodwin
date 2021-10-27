package com.revature.models;


public class Customer extends User {
	
	//private static final Role CUSTOMER = "Customer";
	
	public Customer(String username, String password) {
		super(username, password);
		this.setRole("CUSTOMER");
		numOfUsers++;
		this.setId(56789+numOfUsers);

	}

}
