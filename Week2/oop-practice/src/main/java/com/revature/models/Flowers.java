package com.revature.models;

public class Flowers extends Plants {

	public Flowers(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public Flowers(String type, String reqSun) {
		super(type, reqSun);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void water() {
		needsWatered = false;
		setDaysToNeedWatering(1);
		System.out.println(getType() + " has been watered.");
		
	}


}
