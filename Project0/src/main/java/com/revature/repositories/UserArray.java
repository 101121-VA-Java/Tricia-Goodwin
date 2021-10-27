package com.revature.repositories;


import com.revature.models.User;

public class UserArray implements UserDao{
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

}
