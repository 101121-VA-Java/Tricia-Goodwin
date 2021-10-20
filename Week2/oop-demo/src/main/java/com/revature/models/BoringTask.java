package com.revature.models;

import java.time.LocalDate;

public class BoringTask extends Task {

	public BoringTask(String taskName) {
		super(taskName);
		// TODO Auto-generated constructor stub
	}

	public BoringTask(String taskName, LocalDate dueDate) {
		super(taskName, dueDate);
		// TODO Auto-generated constructor stub
	}
	
	public void procrastinate(){
		this.setDueDate(this.getDueDate().plusDays(1));
	}

}
