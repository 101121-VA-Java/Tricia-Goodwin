package com.revature.models;

public class Offer {
	private int CustomerID;
	private long isbn;
	private boolean accepted;
	private boolean payedFor;
	
	
	
	
	
	
	public Offer(int customerID, long isbn, boolean accepted, boolean payedFor) {
		super();
		CustomerID = customerID;
		this.isbn = isbn;
		this.accepted = accepted;
		this.payedFor = payedFor;
	}
	
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public boolean isPayedFor() {
		return payedFor;
	}
	public void setPayedFor(boolean payedFor) {
		this.payedFor = payedFor;
	}

	@Override
	public String toString() {
		return "Offer [CustomerID=" + CustomerID + ", isbn=" + isbn + ", accepted=" + accepted + ", payedFor="
				+ payedFor + "]";
	}
	
	
	

}
