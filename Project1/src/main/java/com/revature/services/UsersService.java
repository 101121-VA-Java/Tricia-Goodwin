package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.DaoFactory;
import com.revature.daos.UsersDao;
import com.revature.models.Users;

public class UsersService {
	private UsersDao ud;
	
	public UsersService() {
		super();
		ud = DaoFactory.getDaoFactory().getUsersDao();
		
	}
	
	public List<Users> getAllUsers(){
		List<Users> users = ud.getAllUsers().stream()
				.map(u -> {
					u.setPassword(null);
				return u;
				})
				.collect(Collectors.toList());
		return users;
		
	}
	


	public Users findUser(int id) {
		Users user = ud.findUser(id);
		return user;
	}

	
//	public List<Users> getUsersmanId(){
//		List<Users> users = ud.getAllUsers().stream()
//				.map(u -> {
//					u.setPassword(null);
//				return u;
//				})
//				.collect(Collectors.toList());
//		return users;
//		
//	}

}
