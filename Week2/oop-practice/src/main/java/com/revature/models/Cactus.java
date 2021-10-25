package com.revature.models;

public class Cactus extends Plants {

	public Cactus(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Cactus(String type, String reqSun) {
		super(type, reqSun);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void water() {
		needsWatered = false;
		setDaysToNeedWatering(14);
		System.out.println(getType() + " has been watered.");
	}


}
