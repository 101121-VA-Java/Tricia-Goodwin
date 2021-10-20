package com.revature.models;

import java.time.LocalDate;

public class ImportantTask extends Task{
	
	
	public ImportantTask(String taskName, LocalDate dueDate) {
		super(taskName, dueDate);
		// TODO Auto-generated constructor stub
	}

	public ImportantTask(String taskName) {
		super(taskName);
		// TODO Auto-generated constructor stub
	}

	public void stress() {
		//bc duedate is private in Task, it is not accessible from child class and a setter and getter were needed to alter it.
		this.setDueDate(this.getDueDate().minusDays(1));
	}
}
