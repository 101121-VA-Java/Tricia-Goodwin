package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;

public interface UserDao {
	
	
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
