package com.revature.repositories;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserDao {
	
	
		User addUser(String username, String password);
		User[] getAllBooksellers();
		User[] getAllCustomers();
		User getUserById(int id);
		boolean findUser(String username) throws UserNotFoundException;
		User retrieveUser(String username);
		//User addUser(String username, String password, String role);
		User[] addUser(User[] users,String username, String password, String role);
}
