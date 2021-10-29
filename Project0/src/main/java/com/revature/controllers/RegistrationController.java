package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;

public class RegistrationController {
	User[] users = {new Bookseller("Tricia","password")};

	public static void newUser() {

		Scanner scnu = new Scanner(System.in);

		System.out.println("Create a New User.");
		System.out.println("Is new user an employee? ");
		String yn = scnu.nextLine();
		System.out.println("Enter a username:");
		String username = scnu.nextLine();
		System.out.println("Enter a password:");
		String password = scnu.nextLine();

		switch (yn) {
		case "yes":
		case "y":
		case "Yes":
		case "Y":

			User p = new Bookseller(username, password);
			// TODO: Ensure that username is not already in use
			System.out.println(p.toString());
			break;

		default:

			User p1 = new Customer(username, password);
			// TODO: Ensure that username is not already in use
			System.out.println(p1.toString());
			break;

		}

		scnu.close();

	}

	public static void logIn() {
		Scanner scli = new Scanner(System.in);

		System.out.println("Enter your username:");
		String username = scli.nextLine();
		System.out.println("Enter your password:");
		String password = scli.nextLine();
		
		if(findUser(username)) {
			User u = retrieveUser(username);
		}else {
			System.out.println("Invalid password or user name");
			logIn();		}
		User u = findUser(username);
		
		if(u.getPassword().equals(password)) {
			System.out.println("Log in complete.");
			if(u.getRole().equals("ADMIN")||u.getRole().equals("OWNER")) {
				BackController.EmployeeMenu();
			}else {
				BackController.CustomerMenu();
			}
		}else {
			System.out.println("Invalid password or user name");
			logIn();
		}
		
		

		scli.close();
	}



}
