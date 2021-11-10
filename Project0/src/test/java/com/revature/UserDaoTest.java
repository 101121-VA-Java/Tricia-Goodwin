package com.revature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.*;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Books;
import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.repositories.UserDao;

public class UserDaoTest {

	@BeforeAll
	public static void setup() {
		
	}
	
	@Order(2)
	@Test
	public void addCustomerValid() {
		User[] expected = {new Bookseller("Tricia", "password") , new Bookseller("Tricia1", "pass", "OWNER"), new Customer("Patricia", "password123"), new Customer("Trisha", "pass")};
	
		User[] users = {new Bookseller("Tricia", "password") , new Bookseller("Tricia1", "pass", "OWNER"), new Customer("Patricia", "password123")};
		User[] actual = UserArray.addUser(users, "Trisha", "pass", "CUSTOMER");
		assertArrayEquals(expected, actual);
	}
	
	
	List<User> getAllBooksellers();
	List<User> getAllCustomers();
	User getUserById(int id, String role);
	Customer retrieveCustomer(String username);
	Bookseller retrieveBookseller(String username);
	boolean findCustomer(String username) throws UserNotFoundException;
	boolean findBookseller(String username) throws UserNotFoundException;
	boolean addUser(String fname, String lname, String username, String password, String role);
	public boolean fireBookseller(String username);
	boolean updateBookseller(String username);
}
