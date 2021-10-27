package com.revature.models;

public class RareBooks extends Books {
	private double suggestedPrice;

	public RareBooks(String title, String author) {
		super(title, author);
		// TODO Auto-generated constructor stub
	}

	public RareBooks(String title, String author, long l) {
		super(title, author, l);
		// TODO Auto-generated constructor stub
	}

	public double getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(double suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}
	

}
