package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.repositories.BooksDao;
import com.revature.repositories.BooksPostgres;
import com.revature.repositories.BooksScanner;
import com.revature.repositories.UserDao;
import com.revature.repositories.UsersPostgres;

public class RegistrationController {
	
	static UserDao ud = new UsersPostgres();
	
	public static void newUser(String role) {

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


			if(findUser(username)) {
				System.out.println("Username not available");
				newUser(role);
			}

			User p1 = new Customer(fname, lname, username, password);
			if(ud.addUser(fname, lname, username, password, role)) {
				System.out.println("true");

			p1 = ud.retrieveCustomer(username);
			System.out.println(p1.toString());
			}


		

	}

	public static void logIn(String role) {
		Scanner sc = BooksScanner.getScanner();
		boolean exit = false;
		boolean custmer = false;
		boolean bksellr = false;

		System.out.println("Enter your username:");
		String username = sc.nextLine();
		System.out.println("Enter your password:");
		String password = sc.nextLine();
		if (role.equals("Admin") || role.equals("Owner")) {
			if (findUser(username)) {
				System.out.println("Bookseller found");
				Bookseller u = ud.retrieveBookseller(username);
				System.out.println(u);
				bksellr = true;
				
			} else {
				System.out.println("Invalid password or user name");
				System.out.println("Try again or return to last menu?");
				System.out.println("1. Try again");
				System.out.println("2. Return to previous menu");

				int choice = sc.nextInt();
				if (choice == 1) {
					logIn(role);
				} else {
					FrontController.firstMenu();
					exit = true;
					
				}
			}
		} else {
			if (findUser(username)) {
				Customer u = ud.retrieveCustomer(username);
				custmer = true;
			} else {
				System.out.println("Invalid password or user name");
				System.out.println("Try again or return to last menu?");
				System.out.println("1. Try again");
				System.out.println("2. Return to previous menu");

				int choice = sc.nextInt();
				if (choice == 1) {
					logIn(role);
				} else {
					FrontController.firstMenu();
					exit = true;
				}
			}
		}
		User u = null;
		if(!exit&&custmer) {
			 u = ud.retrieveCustomer(username);
		}else if (!exit&&bksellr) {
			 u = ud.retrieveBookseller(username);
		}
		System.out.println(u);
		
		if (u.getPassword().equals(password)&&!exit) {
			System.out.println("Log in complete.");
			if (u.getRole().equals("Admin")) {
				BackController.EmployeeMenu(u.getId());
			} else if (u.getRole().equals("Owner")) {
				BackController.OwnerMenu();
			} else {
				BackController.CustomerMenu(u.getId());
			}
		} else if(!exit){
			System.out.println("Invalid password or user name");
			logIn(role);
		}

	}



	private static boolean findUser(String username) {
		boolean found = false;
		if(ud.findBookseller(username)||ud.findCustomer(username)) {
			found = true;
		}
		return found;
	}



}
