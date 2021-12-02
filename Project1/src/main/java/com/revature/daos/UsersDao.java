package com.revature.daos;

import java.util.List;

import com.revature.models.Role;
import com.revature.models.Users;

public interface UsersDao {
	Users addUser(String fname, String lname, String username, String password, String email, String role);
	List<Users> getAllUsers();
	Users findUser(String username);
	Users findUser(int ID);
	Boolean userExists(String username);
	Role userRole(String username);
	//List<Users> getUsersManId(int Id);
	
}
