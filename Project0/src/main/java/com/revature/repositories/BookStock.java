package com.revature.repositories;

import java.util.ArrayList;

import com.revature.models.Books;

public class BookStock {

	public static void main(String[] args) {

		// Books(String title, String author, long isbn, boolean released, int stock,
		// String genre, double price,
		// boolean hardcover, boolean nytbestseller)

		Books b = new Books("Dictionary", "Webster", 9780877792963l, true, 12, "reference", 19.99, true, false);
//        b.stock = 12;
//        b.price = 19.99;
//        b.genre = "reference";
//        b.released = true;
//        b.hardcover = true;

		Books b1 = new Books("Ninth House", "Bardugo", 9781250313072l, true, 0, "Young Adult", 21.99, true, false);
//		b1.stock = 0;
//		b1.price = 21.99;
//		b1.genre = "Young Adult";
//		b1.released = true;
//		b1.hardcover = false;
//		b1.nytbestseller = true;

		Books b2 = new Books("Untitled - Alex Stern #2", "Bardugo", 0l, false, 0, "Young Adult", 29.99, true, false);
//		b2.stock = 0;
//		b2.price = 29.99;
//		b2.genre = "Young Adult";
//		b2.released = false;
//		b2.hardcover = true;

		Books b3 = new Books("The Martian", "Weir", 9780553418026l, true, 4, "Sci-fi", 16.99, false, false);
//		b3.stock = 4;
//		b3.price = 16.99;
//		b3.genre = "Sci-Fi";
//		b3.released = true;
//		b3.hardcover = false;
//		b3.nytbestseller = false;

		Books b4 = new Books("Hail Mary", "Weir",  9780593135204l, true, 10, "Sci-Fi", 24.99, true, true);
//		b4.stock = 10;
//		b4.price = 24.99;
//		b4.genre = "Sci-fi";
//		b4.released = false;
//		b4.hardcover = true;
		
		ArrayList<Books> BookList = new ArrayList<>();
		BookList.add(b);
		BookList.add(b1);
		BookList.add(b2);
		BookList.add(b3);
		BookList.add(b4);
		
		for(Books book: BookList) {
			System.out.println(book.toString());
		}
		
	}

}
