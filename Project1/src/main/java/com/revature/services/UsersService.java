package com.revature.services;

import com.revature.daos.DaoFactory;
import com.revature.daos.UsersDao;

public class UsersService {
	private UsersDao ud;
	
	public UsersService() {
		ud = DaoFactory.getDaoFactory().getUsersDao();
		
	}
	
	public List<Users> getAllUsers(){
		List<Users> users = ud.g
	}

}
