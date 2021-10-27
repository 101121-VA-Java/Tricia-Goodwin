package com.revature.controllers;

import java.util.Scanner;

public class FrontController {

	public FrontController() {
		private Scanner sc;
		private UserController uc;
		
		public FrontController() {
			sc = new Scanner(System.in);
// TODO: figure out what he did here
		}
		
		public void run() {
			boolean run = true;
			
			while(run) {
				System.out.println("Please select an option: ");
				System.out.println("1: Register");
				System.out.println("2. Login with an existing account.");
				System.out.println("3. Exit");
				
				String choice = sc.nextLine();
				
				switch(choice) {
				case"1":
					break;
				case"2":
					break;
				case"3":
					run = false;
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
				
				System.out.println("Please select an option: ");
				
			}
			
		}
		
		sc.close();
	}

}
