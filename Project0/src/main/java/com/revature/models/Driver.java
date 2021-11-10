package com.revature.models;

import com.revature.controllers.FrontController;
import com.revature.repositories.BooksDao;
import com.revature.repositories.BooksPostgres;
import com.revature.repositories.BooksScanner;

public class Driver {

	public static void main(String[] args) {

		//FrontController.firstMenu();
		//BooksScanner.closeScanner();
		BooksDao bd = new BooksPostgres();

		System.out.println(bd.getAllBooks());
		
	}

}
