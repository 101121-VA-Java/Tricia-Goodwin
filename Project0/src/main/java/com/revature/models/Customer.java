package com.revature.models;


public class Customer extends User {
	
	//private static final Role CUSTOMER = "Customer";
	private int numBooks;
	
	public Customer(String username, String password) {
		super(username, password);
		this.setRole("CUSTOMER");
		this.setNumBooks(0);


	}

	public Customer(String fname, String lname, String username, String password) {
		super(fname, lname, username, password);
		this.setRole("CUSTOMER");
		this.setNumBooks(0);

	}

	public Customer(int ID, String fname, String lname, String username, String role, String password, int booksOwned) {
		super(fname, lname, username, role, password);
		this.setNumBooks(booksOwned);
		this.setId(ID);

	}

	public int getNumBooks() {
		return numBooks;
	}

	public void setNumBooks(int numBooks) {
		this.numBooks = numBooks;
	}
	
	
	

}
