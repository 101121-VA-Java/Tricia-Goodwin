package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Books;
import com.revature.models.User;
import com.revature.repositories.BooksDao;
import com.revature.repositories.BooksPostgres;
import com.revature.repositories.BooksScanner;
import com.revature.repositories.UserDao;
import com.revature.repositories.UsersPostgres;

public class BackController {
	
	static Scanner sc = BooksScanner.getScanner();
	static BooksDao bd = new BooksPostgres();

	public static void EmployeeMenu(int ID) {
		
		int choice = 0;
		boolean exit = false;
		
		
		while(!exit) {
			System.out.println("\nChoose an option:");
			System.out.println("1. Add a new book");
			System.out.println("2. Find location of book");
			System.out.println("3. Update Price or Stock of Item");
			System.out.println("4. Check Status of book by ISBN");
			System.out.println("5. Remove Item");
			System.out.println("6. See pending offers");
			System.out.println("7. See All Books");
			System.out.println("8. Close");
			String choicestr = sc.nextLine();
			choice = Integer.parseInt(choicestr);
			switch(choice) {
			case 1: 
				BooksController.newBook();
				System.out.println("End of case");
				break;
			case 2:
				System.out.println("Look up by title or ISBN?");
				String lookUp = sc.nextLine();
				if (lookUp.equalsIgnoreCase("ISBN")) {
					System.out.println("ISBN: ");
					Long isbn = sc.nextLong();
					bd.findBook(isbn);
				} else {
					System.out.println("Title: ");
					String title = sc.nextLine();
					bd.findBook(title);
				}
				break;
			case 3:
				System.out.println("Enter isbn of book you wish to update:");
				Long isbnu = sc.nextLong();
				sc.nextLine();
				bd.updateBook(isbnu);
				System.out.println(bd.getBookByISBN(isbnu));

				break;
			case 4:
				System.out.println("Enter isbn of book you wish to view:");
				Long isbnv = sc.nextLong();
				sc.nextLine();
				System.out.println(bd.getBookByISBN(isbnv));
				break;
			case 5:
				System.out.println("Enter isbn of book you wish to delete:");
				Long isbn = sc.nextLong();
				sc.nextLine();
				System.out.println(bd.getBookByISBN(isbn));
				System.out.println("Confirm deleting book? (y/n): ");
				String yn = sc.nextLine();
				if(yn.equals("y")||yn.equals("Y")) {
					if(bd.deleteBook(isbn)) {
						System.out.println("Book deleted from system");
					}
					
					}else {
						System.out.println("Book not removed.");
				}
			case 6:
				bd.seePendingOffers();
				System.out.println("Accept offer?(y/n)");
				String ny = sc.nextLine();
					if (ny.equals("y")||ny.equals("Y")) {
						System.out.println("Enter customer ID:");
						int cID = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter book isbn:");
						long isbnO = sc.nextLong();
						sc.nextLine();
						bd.acceptOffer(cID, isbnO);
					}

				break;
			case 7:
				List <Books> result = bd.getAllBooks();
				for(Books book:result) {
					System.out.println(book);
				}
				break;
			case 8:	
				exit = true;
				break;	
			default:
				System.out.println("Invalid input");
				System.out.println("Please retry");
				break;
					
			}
			
		} 

	}
	
	public static void CustomerMenu(int ID) {
		int choice = 0;
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\nChoose an option:");
			System.out.println("1. See books by genre");
			System.out.println("2. See books by Author");
			System.out.println("3. Find book by title");
			System.out.println("4. Find book by ISBN");
			System.out.println("5. See available genres");
			System.out.println("6. Purchase book");
			System.out.println("7. See Pending Purchases");
			System.out.println("8. See My Owned Books");
			System.out.println("9. Log Out");
			
			choice = sc.nextInt();
			sc.nextLine();

			switch(choice) {
			case 1: 
				List <Books> result = bd.getAllBooksByGenre();
				for(Books book:result) {
					System.out.println(book);
				}
				break;
			case 2:
				List <Books> AuthorWorks = bd.getAllBooksByAuthor();
				for(Books book:AuthorWorks) {
					System.out.println(book);
				}
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
				bd.listGenres();
				break;
			case 6:
				System.out.println("Please enter the isbn of the book you wish to purchase: ");
				long isbnBuy = sc.nextLong();
				if(bd.offerBook(ID, isbnBuy)) {
					System.out.println("Offer Submitted, please wait for your offer to be accepted by an employee");
				}else {
					System.out.println("Offer did not go through, please try again");
				}
				break;
			case 7:
				bd.seeMyOffers(ID);
				break;
			case 8:
				bd.seeMyBooks(ID);
				
				break;
			case 9:
				exit = true;
				break;
			default:
				System.out.println("Invalid input");
				System.out.println("Please retry");
				break;
			}
		}
				
	}
	
	public static void OwnerMenu(int ID) {
		Scanner sc = BooksScanner.getScanner();
		int choice = 0;
		boolean exit = false;
		UserDao ud = new UsersPostgres();
		while(!exit) {
			System.out.println("\nChoose an option:");
			System.out.println("1. Employee Menu");
			System.out.println("2. Add a new employee");
			System.out.println("3. View all employees");
			System.out.println("4. View All transactions");
			System.out.println("5. View pending transactions");
			System.out.println("6. Update employee");
			System.out.println("7. Fire Employee");
			System.out.println("8. View Week's transactions");
			System.out.println("9. Close");
			String choicestr = sc.nextLine();
			choice = Integer.parseInt(choicestr);
			System.out.println("Input taken");
			switch(choice) {
			case 1: 
				BackController.EmployeeMenu(ID);

				break;
			case 2:
				RegistrationController.newUser("Admin");
				break;
			case 3:
				List<User> staff = ud.getAllBooksellers();
				for(User emp:staff) {
					System.out.println(emp);
				}
				break;
			case 4:
				bd.seeAcceptedOffers();
				break;
			case 5:
				bd.seePendingOffers();
				break;
			case 6:
				System.out.println("Enter employee username to update:");
				String emp = sc.nextLine();
				if(ud.updateBookseller(emp)) {
					System.out.println("Employee has been updated");
				}
				break;
			case 7:
				System.out.println("Enter employee username");
				String firedEmp = sc.nextLine();
				System.out.println(ud.retrieveBookseller(firedEmp));
				System.out.println("Fire employee?(y/n): ");
				String confirm = sc.nextLine();
				if(confirm.equals("y")||confirm.equals("Y")) {
					ud.fireBookseller(firedEmp);
				}
				break;
			case 8:
				bd.seeAcceptedOffers();
				bd.seePendingOffers();
				break;
			case 9:	
				exit = true;
				break;
			default:
				System.out.println("Invalid input");
				System.out.println("Please retry");	
				break;
					
			}
			
		} 

	}

}
