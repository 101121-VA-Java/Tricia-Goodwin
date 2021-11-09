package com.revature.repositories;

import java.util.List;

import com.revature.models.Books;

public interface BooksDao {
	
	//Employee[] getAllEmployees();
	//Employee getEmployeeById(int id);
	
	List<Books> getAllBooks();
	
	Books getBookByTitle(String title);
	Books getBookByISBN(long isbn);
	long addBook(Books b);
	String findBook(long isbn);
	String findBook(String title);

	List<Books> getAllBooksByAuthor();

	List<Books> getAllBooksByGenre();

	void listGenres();

	boolean offerBook(int Cust_id, long isbn);

	boolean sellBook(int Cust_id, long isbn);

	boolean pendingOffer(int Cust_id, long isbn);

	boolean deleteBook(Long isbn);

	boolean updateBook(long isbn);

	void seeMyBooks(int iD);

	void seeMyOffers(int iD);

	void seePendingOffers();

	void acceptOffer(int cID, long isbnO);

	void seeAcceptedOffers();

	
	

}
