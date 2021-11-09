package com.revature.models;

public class Bookseller extends User {

	//private static final Role ADMIN = null;
	private double hrlyRate;

	public Bookseller(String username, String password) {
		super(username, password);
		this.setRole("ADMIN");
		numOfUsers++;

		setHrlyRate(16);
	}
	

	public Bookseller(String username, String password, String role) {
		super(username, password);
		this.setRole(role);
		numOfUsers++;
		if(role.equals("ADMIN")) {
			setHrlyRate(16);
		}else if(role.equals("OWNER")) {
			setHrlyRate(30);
		}

	}
	

	public Bookseller(String fname, String lname, String username, String password, String role) {
		super(fname, lname, username, password);
		this.setRole(role);
		numOfUsers++;
		if(role.equals("ADMIN")) {
			setHrlyRate(16);
		}else if(role.equals("OWNER")) {
			setHrlyRate(30);
		}
		
		
	}


	public Bookseller(int ID, String fname, String lname, String username, String password, double hrlyRate) {
		super(fname, lname, username, password);
		this.hrlyRate = hrlyRate;
		this.setId(ID);
		if(username.equals("Owner")) {
			this.setRole("Owner");
		}else {
		this.setRole("Admin");
		}
	}


	public double getHrlyRate() {
		return hrlyRate;
	}

	public void setHrlyRate(double hrlyRate) {
		this.hrlyRate = hrlyRate;
	}


	@Override
	public String toString() {
		int id = this.getId();
		String username = this.getUsername();
		String fname = this.getFname();
		String lname = this.getLname();
		
		return "Bookseller [id=" + id + ", username=" + username + ", Name = "+fname + " " + lname + ", hrlyRate=" + hrlyRate + "]";

	}
	
	

}
