package com.revature.controllers;

import java.util.Scanner;

public class BackController {

	public static void EmployeeMenu() {
		Scanner sc2 = new Scanner(System.in);
		int choice = 0;
		boolean exit = false;
		
		while(!exit) {
			System.out.println("Choose an option:");
			System.out.println("1. Add a new book");
			System.out.println("2. Close");
			String choicestr = sc2.nextLine();
			choice = Integer.parseInt(choicestr);
			System.out.println("Input taken");
			switch(choice) {
			case 1: 
				BooksController.newBook();
				System.out.println("End of case");
				break;
			case 2:	
				System.out.println("Exit runs");
				exit = true;
				break;
			default:
				System.out.println("Default case");
				break;
					
			}
			
		} 
		sc2.close();
	}
	
	public static void CustomerMenu() {
		
	}

}
