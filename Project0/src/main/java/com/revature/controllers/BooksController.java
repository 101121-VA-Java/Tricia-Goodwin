package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Books;

public class BooksController {
	
	public static void newBook() {
		Scanner scnb = new Scanner(System.in);
		
		System.out.println("Enter New Book:");
		System.out.println("Title: ");
		String title = scnb.nextLine();
		System.out.println("Author: ");
		String author = scnb.nextLine();
		System.out.println("ISBN: ");
		String isbnstr = scnb.nextLine();
		Long isbn = Long.parseLong(isbnstr);
		System.out.println("Is the book released yet? (y/n): ");
		String yn = scnb.nextLine();
		yn.toLowerCase();
		System.out.println("Number in stock: ");
		int stock = scnb.nextInt();
		scnb.nextLine();
		System.out.println("Genre: ");
		String genre = scnb.nextLine();
		System.out.println("Price: ");
		double price = scnb.nextDouble();
		scnb.nextLine();
		System.out.println("Is this book in hardcover? (y/n): ");
		
		String yn2 = scnb.nextLine();
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
		 System.out.println(book);
		 
		 scnb.close();
	}


	}


