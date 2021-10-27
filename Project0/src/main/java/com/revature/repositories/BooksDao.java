package com.revature.repositories;

import com.revature.models.Books;

public interface BooksDao {
	
	//Employee[] getAllEmployees();
	//Employee getEmployeeById(int id);
	
	Books[] getAllBooks();
	
	Books getBookByTitle(String title);
	Books getBookByISBN(int isbn);
	long addBook(Books b);
	String findBook(int isbn);
	String findBook(String title);
	
	

}
