package com.revature.driver;

import java.time.LocalDate;
import java.util.Scanner;

//import com.revature.models.Task;
//import com.revature.models.ImportantTask;
//import com.revature.models.BoringTask;
//import com.revature.models.UnimportantTask;
//import com.revature.models.User;
import com.revature.models.*;

public class Driver{

	private static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {


		User u = new User();
		u.setUsername("Tricia");

		u.setPassword("Password123"); 

		//ImportantTask it = new ImportantTask("Change Flat",LocalDate.now());

		//System.out.println(it);


		Task t1 = new Task("Oil Change", LocalDate.now().plusDays(7));
		Task t2 = new Task("Water Plants", LocalDate.now().plusDays(1));
		Task t3 = new BoringTask("Return Library Books");
		Task t4 = new ImportantTask("fix flat tire", LocalDate.now());
		Task t5 = new DailyTask("Feed Cats");


		Task[] tasks = {t1,t2,t3,t4,t5};

		u.setTasks(tasks);

		System.out.println(u);
		((DailyTask) t5).finished();

		System.out.println(u);

		System.out.println("Add New Task:");
		String yn = sc.nextLine();
		while(yn.equals("y")) {
			System.out.println("Rate Task Importance ( normal, important, boring, or daily): ");
			String choice = sc.nextLine();

			switch(choice) {
		
			case "normal":
				System.out.println("Task Name: ");
				String name = sc.nextLine();
				Task t = new Task(name);
				System.out.println(t);
				break;
			
			case "important":
				System.out.println("Task Name: ");
				String name1 = sc.nextLine();
				Task it = new ImportantTask(name1);
				System.out.println(it);
				break;
			
			case "boring":
				System.out.println("Task Name: ");
				String name2 = sc.nextLine();
				Task bt = new BoringTask(name2);
				System.out.println(bt);
				break;
			
			case "daily":
				System.out.println("Task Name: ");
				String name3 = sc.nextLine();
				Task dt = new DailyTask(name3);
				System.out.println(dt);
				break;
			
			default:
				System.out.println("Invalid Choice");
				break;

			}
			
			System.out.println("New Task: ");
			yn = sc.nextLine();
		}



	}


}