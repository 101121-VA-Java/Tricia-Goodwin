package com.revature;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import com.revature.models.Books;
import com.revature.repositories.*;

public class BooksDaoTest {
	private static BooksDao bd;
	@BeforeAll
	public static void setup() {
		Books[] b = {new Books("The Priory of the Orange Tree", "Shannon",9781635570304l), new Books("Ninth House", "Bardugo",9781250751362l)};
		bd = new BookArray(b);
	}
	
	
	@Test
	public void getAllBooks() {
		Books[] expected = {new Books("The Priory of the Orange Tree", "Shannon",9781635570304l)};
		Books[] actual = bd.getAllBooks();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void addBookValid() {
		Books[] expected = {new Books("The Priory of the Orange Tree", "Shannon"), new Books("Gideon the Ninth","Muir",9781250313188l)};
		bd.addBook(new Books("Gideon the Ninth","Muir"));
		
		assertArrayEquals(expected, bd.getAllBooks());
	}

}
