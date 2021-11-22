package com.revature.services;

import com.revature.daos.DaoFactory;
import com.revature.daos.UsersDao;
import com.revature.models.Role;
import com.revature.models.Users;

public class AuthorizationService {
	
	private UsersDao ud;
	
	public AuthorizationService() {
		ud = DaoFactory.getDaoFactory().getUsersDao();
	}
	
	public String logIn(String username, String password) {
		String LoggedInToken = null;
		Users principal = ud.findUser(username);
		if(principal != null && principal.getPassword().equals(password)) {
			LoggedInToken = principal.getID() + ":" + principal.getRole();
		}
		return LoggedInToken;
	}

	
	public boolean isAllowed(String loggedInToken, Role allowedRole) {
		boolean isAllowed = false;
		if (loggedInToken != null) {
			String[] token = loggedInToken.split(":");
			int userId = Integer.parseInt(token[0]);
			Role userRole = Role.valueOf(token[1]);
			Users principal = ud.findUser(userId);
			if(principal.getRole() == userRole&& userRole == allowedRole) {
				isAllowed = true;
			}
		}
		
		return isAllowed;
	}

}
