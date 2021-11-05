package com.revature.repositories;

import java.util.Scanner;

public class BooksScanner {
	private static Scanner sc;
	
	private BooksScanner() {};
	
	public static synchronized Scanner getScanner() {
		if(sc == null) {
			sc = new Scanner(System.in);
			
		}
		return sc;
	}
	
	public static void closeScanner() {
		sc.close();
	}
}
