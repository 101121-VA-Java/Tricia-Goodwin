package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Books;
import com.revature.repositories.BooksDao;
import com.revature.repositories.BooksPostgres;
import com.revature.repositories.BooksScanner;

public class BooksController {
	
	static BooksDao bd = new BooksPostgres();
	
	public static void newBook() {
		Scanner sc = BooksScanner.getScanner();
		
		System.out.println("Enter New Book:");
		System.out.println("Title: ");
		String title = sc.nextLine();
		System.out.println("Author: ");
		String author = sc.nextLine();
		System.out.println("ISBN: ");
		String isbnstr = sc.nextLine();
		Long isbn = Long.parseLong(isbnstr);
		System.out.println("Is the book released yet? (y/n): ");
		String yn = sc.nextLine();
		yn.toLowerCase();
		System.out.println("Number in stock: ");
		int stock = sc.nextInt();
		sc.nextLine();
		System.out.println("Genre: ");
		String genre = sc.nextLine();
		System.out.println("Price: ");
		double price = sc.nextDouble();
		sc.nextLine();
		System.out.println("Is this book in hardcover? (y/n): ");
		
		String yn2 = sc.nextLine();
		yn2.toLowerCase();
		boolean released = false;
		boolean hardcover = false;
		
		if(yn.equals("y")||yn.equals("yes")) {
			released = true;
		}
		if(yn2.equals("y")||yn2.equals("yes")) {
			hardcover = true;
		}
		
		
		 Books book = new Books(title, author, isbn, released, stock, genre, price, hardcover) ;
		 if(isbn == bd.addBook(book)) {
			 System.out.println(book + " Has been added.");
		 }
		 

	}


	}


