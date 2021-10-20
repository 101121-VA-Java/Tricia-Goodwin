package com.revature.models;

import java.time.LocalDate;

public class DailyTask extends Task {

	public DailyTask(String taskName) {
		super(taskName);
		this.setDueDate(LocalDate.now());
		//LocalDate dueDate = LocalDate.now();
		// TODO Auto-generated constructor stub
	}
	
	public void finished() {
		this.setDueDate(this.getDueDate().plusDays(1));

}

}
