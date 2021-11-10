package com.revature.controllers;

import java.util.Scanner;

import com.revature.repositories.BooksScanner;

public class FrontController {

	public static void firstMenu() {

		Scanner sc = BooksScanner.getScanner();

			boolean exit = false;
			
			while(!exit) {
				System.out.println("\nPlease select an option: ");
				System.out.println("1: Register");
				System.out.println("2. Login with an existing Customer account.");
				System.out.println("3. Login with an existing Employee account.");
				System.out.println("4. Exit");
				
				String choice = sc.nextLine();
				
				switch(choice) {
				case"1":
					RegistrationController.newUser("Customer");
					break;
				case"2":
					RegistrationController.logIn("Customer");
					break;
				case"3":
					RegistrationController.logIn("Admin");
					break;
				case"4":
					exit = true;
					BooksScanner.closeScanner();

					break;
				default:
					System.out.println("Invalid input");
					break;
				}


			}


	}

	

}
