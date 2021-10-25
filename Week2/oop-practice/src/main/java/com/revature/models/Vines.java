package com.revature.models;

public class Vines extends Plants {

	public Vines(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	


	public Vines(String type, String reqSun) {
		super(type, reqSun);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void water() {
		needsWatered = false;
		setDaysToNeedWatering(2);
		System.out.println(getType() + " has been watered.");
		
	}
}
