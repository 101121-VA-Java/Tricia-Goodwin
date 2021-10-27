package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;

public class RegistrationController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Create a New User.");
		System.out.println("Is new user an employee? ");
		String yn = sc.nextLine();
		System.out.println("Enter a username:");
		String username = sc.nextLine();
		System.out.println("Enter a password:");
		String password = sc.nextLine();
		
		switch (yn) {
			case "yes": case "y": case "Yes": case"Y":

				User p = new Bookseller(username,password);
				// TODO: Ensure that username is not already in use
				System.out.println(p.toString());
				break;
				
			default:
				
				User p1 = new Customer(username,password);
				// TODO: Ensure that username is not already in use
				System.out.println(p1.toString());
				break;
	
		
		}

	
		sc.close();
	}	
}


