package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.repositories.BooksScanner;

public class RegistrationController {
	

	public static void newUser() {

		Scanner sc = BooksScanner.getScanner();

		System.out.println("Create a New User.");

		System.out.println("Enter a username:");
		String username = sc.nextLine();
		System.out.println("Enter a password:");
		String password = sc.nextLine();
		System.out.println("Enter your first name: ");
		String fname = sc.nextLine();
		System.out.println("Enter your last name: ");
		String lname = sc.nextLine();



			User p1 = new Customer(fname, lname, username, password);
			// TODO: Ensure that username is not already in use
			
			System.out.println(p1.toString());



		

	}

	public static void logIn() {
		Scanner sc = BooksScanner.getScanner();

		System.out.println("Enter your username:");
		String username = sc.nextLine();
		System.out.println("Enter your password:");
		String password = sc.nextLine();
		
		if(findUser(username)) {
			User u = retrieveUser(username);
		}else {
			System.out.println("Invalid password or user name");
			System.out.println("Try again or return to last menu?");
			System.out.println("1. Try again");
			System.out.println("2. Return to previous menu");
			
			int choice = sc.nextInt();
			if(choice == 1) {
				logIn();		
			} else {
				FrontController.firstMenu();
			}
		}
		User u = retrieveUser(username);
		
		if(u.getPassword().equals(password)) {
			System.out.println("Log in complete.");
			if(u.getRole().equals("ADMIN")){
				BackController.EmployeeMenu();
			}else if(u.getRole().equals("OWNER")) {
				BackController.OwnerMenu();
			}else {
				BackController.CustomerMenu();
			}
		}else {
			System.out.println("Invalid password or user name");
			logIn();
		}
		
		


	}

	private static User retrieveUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean findUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}



}
