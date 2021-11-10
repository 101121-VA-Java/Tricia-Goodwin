package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.BooksController;
import com.revature.controllers.FrontController;
import com.revature.models.Books;
import com.revature.repositories.BooksDao;
import com.revature.repositories.BooksPostgres;
import com.revature.repositories.BooksScanner;

public class JdbcDriver {

	private static Logger log = LogManager.getRootLogger();

	
	public static void main(String[] args) {
				


				
				
		FrontController.firstMenu();
		BooksScanner.closeScanner();
			
		}
	

}
