package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.*;

import com.revature.models.Books;
import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.repositories.BookArray;
import com.revature.repositories.UserArray;
import com.revature.repositories.UserDao;

public class UserDaoTest {

	@BeforeAll
	public static void setup() {
		
	}
	
	@Test
	public void addCustomerValid() {
		User[] expected = {new Bookseller("Tricia", "password") , new Bookseller("Tricia1", "pass", "OWNER"), new Customer("Patricia", "password123"), new Customer("Trisha", "pass")};
	
		User[] users = {new Bookseller("Tricia", "password") , new Bookseller("Tricia1", "pass", "OWNER"), new Customer("Patricia", "password123")};
		User[] actual = UserArray.addUser(users, "Trisha", "pass", "CUSTOMER");
		assertArrayEquals(expected, actual);
	}
}
