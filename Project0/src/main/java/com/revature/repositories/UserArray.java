package com.revature.repositories;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;

public class UserArray implements UserDao {
	private User[] users;

	public UserArray() {
		super();
	}

	public UserArray(User[] users) {
		super();
		this.users = users;
	}

	@Override
	public User[] getAllBooksellers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User[] getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	
	@Override
	public User[] addUser(User[] users, String username, String password, String role) {
		User[] temp = new User[users.length + 1];

		int i = 0;

		for (; i < users.length; i++) {
			temp[i] = users[i];

		}
		if (role.equals("CUSTOMER")) {

			temp[i] = new Customer(username, password);
		} else {


			temp[i] = new Bookseller(username, password, role);
		}
		return temp;
	}
	



	@Override
	public boolean findUser(String username) throws UserNotFoundException {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public User retrieveUser(String username) {
		User u;
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				 u = user;
			}
		}
		
		return u;

	}

	@Override
	public User addUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
