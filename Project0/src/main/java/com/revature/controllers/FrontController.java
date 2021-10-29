package com.revature.controllers;

import java.util.Scanner;

public class FrontController {

	public static void firstMenu() {

		Scanner sc = new Scanner(System.in);

			boolean exit = false;
			
			while(!exit) {
				System.out.println("Please select an option: ");
				System.out.println("1: Register");
				System.out.println("2. Login with an existing account.");
				System.out.println("3. Exit");
				
				String choice = sc.nextLine();
				
				switch(choice) {
				case"1":
					RegistrationController.newUser();
					break;
				case"2":
					RegistrationController.logIn();
					break;
				case"3":
					exit = true;
					break;
				default:
					System.out.println("Invalid input");
					break;
				}

				sc.close();
			}


	}

	

}
