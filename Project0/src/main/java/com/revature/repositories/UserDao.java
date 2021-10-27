package com.revature.repositories;

import com.revature.models.User;

public interface UserDao {
	
	
		User addUser(String username, String password);
		User[] getAllBooksellers();
		User[] getAllCustomers();
		User getUserById(int id);

}
