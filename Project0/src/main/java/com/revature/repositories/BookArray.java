package com.revature.repositories;
import com.revature.models.Books;

public class BookArray implements BooksDao{
	
	private Books[] books;

	public BookArray() {
		super();
	}
	

		
	public BookArray(Books[] books) {
		this.books = books;
	}


	@Override
	public long addBook(Books book) {
		Books[] temp = new Books[books.length +1];
		
		int i=0;
		
		for(; i<books.length;i++) {
			temp[i] = books[i];
			
		}
		temp[i] = book;
		
		return book.isbn;
	}


	@Override
	public Books[] getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Books getBookByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Books getBookByISBN(int isbn) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String findBook(int isbn) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String findBook(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
