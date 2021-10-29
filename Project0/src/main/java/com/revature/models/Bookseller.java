package com.revature.models;

public class Bookseller extends User {

	//private static final Role ADMIN = null;
	private double hrlyRate;

	public Bookseller(String username, String password) {
		super(username, password);
		this.setRole("ADMIN");
		numOfUsers++;
		this.setId(12345+numOfUsers);
		setHrlyRate(16);
	}
	

	public Bookseller(String username, String password, String role) {
		super(username, password);
		this.setRole(role);
		numOfUsers++;
		this.setId(12345+numOfUsers);
		if(role.equals("ADMIN")) {
			setHrlyRate(16);
		}else if(role.equals("OWNER")) {
			setHrlyRate(30);
		}

	}


	public double getHrlyRate() {
		return hrlyRate;
	}

	public void setHrlyRate(double hrlyRate) {
		this.hrlyRate = hrlyRate;
	}
	
	

}
