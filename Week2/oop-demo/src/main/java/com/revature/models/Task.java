package com.revature.models;

import java.time.LocalDate;


public class Task {

	public String taskName;
	private LocalDate dueDate; 
	
	
	
	public Task() {
		super();
	}




	public Task(String taskName) {
		super();
		this.taskName = taskName;
	}
	
	
	

	public Task(String taskName, LocalDate dueDate) {
		super();
		this.taskName = taskName;
		this.dueDate = dueDate;
	}




	public String getName() {
		return this.taskName;
	}
	public void setName(String name) {
		this.taskName = name;
	}




	public LocalDate getDueDate() {
		return dueDate;
	}




	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}




	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", dueDate=" + dueDate + "]";
	}
	
	
	
	
	
	

	}


