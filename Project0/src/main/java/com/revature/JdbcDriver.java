package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.controllers.BooksController;
import com.revature.models.Books;
import com.revature.repositories.BooksDao;
import com.revature.repositories.BooksPostgres;
import com.revature.repositories.BooksScanner;

public class JdbcDriver {

	public static void main(String[] args) {
				

				BooksDao bd = new BooksPostgres();

				List<Books> books = bd.getAllBooks();
				for (Books b : books) {
					System.out.println(b);
				}
				
//				Books bnew = new Books("The Martian", "Weir", 553418026l, true, 4, "Sci-fi", 16.99, false, false);

				
				System.out.println(bd.findBook(884555868L));

				System.out.println(bd.findBook("Goats"));
				
				System.out.println(bd.getBookByTitle("Goats"));
				
				System.out.println(bd.getBookByISBN(884555868L));
				
				
				BooksController.newBook();
				BooksController.newBook();
				BooksController.newBook();
				

				List<Books> books2 = bd.getAllBooksByAuthor();
				for (Books b : books2) {
					System.out.println(b);
				}
				
				List<Books> books3 = bd.getAllBooksByGenre();
				for (Books b : books3) {
					System.out.println(b);
				}
				
				
				
				BooksScanner.closeScanner();
			
		}
	

}
