package com.revature.controllers;

import java.util.Scanner;

import com.revature.repositories.BooksDao;
import com.revature.repositories.BooksPostgres;
import com.revature.repositories.BooksScanner;

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
		Scanner sc = BooksScanner.getScanner();
		int choice = 0;
		BooksDao bd = new BooksPostgres();
		boolean exit = false;
		
		while(!exit) {
			System.out.println("Choose an option:");
			System.out.println("1. See books by genre");
			System.out.println("2. See books by Author");
			System.out.println("3. Find book by title");
			System.out.println("4. Find book by ISBN");
			System.out.println("5. Close");
			
			String choicestr = sc.nextLine();
			choice = Integer.parseInt(choicestr);
			System.out.println("Input taken");
			switch(choice) {
			case 1: 
				bd.getAllBooksByGenre();
				break;
			case 2:
				bd.getAllBooksByAuthor();
				break;
			case 3:
				System.out.println("Title: ");
				String title = sc.nextLine();
				bd.getBookByTitle(title);
				break;
			case 4:
				System.out.println("ISBN: ");
				long isbn = sc.nextLong();
				bd.getBookByISBN(isbn);
				break;
			case 5:
				exit = true;
				break;
			default:
				System.out.println("Invalid input");
				System.out.println("Please retry");
				break;
			}
		}
				
	}
	
	public static void OwnerMenu() {
		Scanner sc = BooksScanner.getScanner();
		int choice = 0;
		boolean exit = false;
		
		while(!exit) {
			System.out.println("Choose an option:");
			System.out.println("1. Add a new book");
			System.out.println("2. Add a new employee");
			System.out.println("3. Close");
			String choicestr = sc.nextLine();
			choice = Integer.parseInt(choicestr);
			System.out.println("Input taken");
			switch(choice) {
			case 1: 
				BooksController.newBook();
				System.out.println("End of case");
				break;
			case 3:	
				System.out.println("Exit runs");
				exit = true;
				break;
			default:
				System.out.println("Default case");
				break;
					
			}
			
		} 

	}

}
