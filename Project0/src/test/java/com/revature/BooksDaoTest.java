package com.revature;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import com.revature.models.Books;
import com.revature.repositories.*;

public class BooksDaoTest {
	
	static BooksDao bd = new BooksPostgres();
	
	@BeforeAll
	public static void setup() {
		 
		
		
		}
	List<Books> b = bd.getAllBooks();//Fix later
	
	
	@Order(1)
	@Test
	public void getAllBooksTest() {

		List<Books> actual = bd.getAllBooks();
		assertEquals(24, actual.size());
	}
	
	@Order(2)
	@Test
	public void addBookValid() {
		bd.addBook(new Books("Gideon the Ninth","Muir",593845639l));
		
		assertEquals(25, bd.getAllBooks().size());
	}
	
	@Order(3)
	@Test
	public void deleteBookfromList() {
		bd.deleteBook(593845639l);
		assertEquals(24,bd.getAllBooks().size());
	}
	
	@Order(4)
	@Test
	public void getBookTitle() {
		Books expected = new Books("The Martian", "Weir", 553418026l, true, 10, "Sci-fi", 15.99, false);
		Books actual = bd.getBookByTitle("The Martian");
		assertEquals(expected,actual);
	}
	@Order(5)
	@Test
	public void getBookISBN() {
		Books expected = new Books("The Martian", "Weir", 553418026l, true, 10, "Sci-fi", 15.99, false);
		Books actual = bd.getBookByISBN(553418026l);
		assertEquals(expected,actual);
	}
	
	@Order(6)
	@Test
	public void findBookTitle() {
		String expected = "Sci-fi";
		String actual = bd.findBook("The Martian");
		assertEquals(expected,actual);
	}
	
	@Order(7)
	@Test
	public void findBookISBN() {
		String expected = "Sci-fi";
		String actual = bd.findBook(553418026l);
		assertEquals(expected,actual);
	}
	




}
