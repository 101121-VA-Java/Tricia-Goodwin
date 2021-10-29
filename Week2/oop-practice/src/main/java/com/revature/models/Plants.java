package com.revature.models;

public abstract class Plants implements WaterPlants{
	private String type;
	protected boolean needsWatered;
	private int daysToNeedWatering;
	private String reqSun;
	
	public Plants(String type) {
		super();
		this.type = type;
		setNeedsWatered(true);
		setDaysToNeedWatering(0);
	}
	
	
	public Plants(String type, String reqSun) {
		super();
		this.type = type;
		this.reqSun = reqSun;
		setNeedsWatered(true);
		setDaysToNeedWatering(0);
	}


	public void dayPasses() {
		setDaysToNeedWatering(getDaysToNeedWatering() -1);
		if (getDaysToNeedWatering() == 0){
			setNeedsWatered(true);
		}
	}
	
	
	public void dayPasses(int days) {
		setDaysToNeedWatering(getDaysToNeedWatering() - days);
		if (getDaysToNeedWatering() < 1){
			setDaysToNeedWatering(0);
			setNeedsWatered(true);
		}
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isNeedsWatered() {
		return needsWatered;
	}

	public void setNeedsWatered(boolean needsWatered) {
		this.needsWatered = needsWatered;
	}


	public abstract void water();
	

	public int getDaysToNeedWatering() {
		return daysToNeedWatering;
	}

	public void setDaysToNeedWatering(int daysToNeedWatering) {
		this.daysToNeedWatering = daysToNeedWatering;
	}


	public String getReqSun() {
		return reqSun;
	}

	public void setReqSun(String reqSun) {
		this.reqSun = reqSun;
	}

	@Override
	public String toString() {
		return "Plants [type=" + type + ", needsWatered=" + needsWatered + ", daysToNeedWatering=" + daysToNeedWatering
				+ ", reqSun=" + reqSun + "]";
	}


	
	
	

}
