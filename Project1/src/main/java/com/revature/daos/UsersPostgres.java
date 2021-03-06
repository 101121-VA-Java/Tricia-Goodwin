package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Role;
import com.revature.models.Users;
import com.revature.util.ConnectionUtil;

public class UsersPostgres implements UsersDao {
	private static Logger log = LogManager.getRootLogger();
	



	
	@Override
	public Users addUser(int ID, String fname, String lname, String username, String password, String email, String role) {
		Users u = new Users(username, password,fname, lname, email, Role.valueOf(role));
		boolean success = false;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "insert into ERS_USERS (ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, fname);
			ps.setString(5, lname);
			ps.setString(6, email);
			if(role.equals("MANAGER")) {
				ps.setInt(7, 2);
			}else if(role.equals("ADMIN")) {
				ps.setInt(7, 3);
			}else {
				ps.setInt(7, 1);
			}
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			success = true;	
				 
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
			log.catching(e);
		} 
	if(success) {
		return u;
	}else {
		return null;
	}
	}


	@Override
	public Users updateUser(int ID, String fname, String lname,String username, String password, String email) {
		boolean success = false;
		Users u = findUser(username);
		u.setEmail(email);
		u.setFname(fname);
		u.setLname(lname);
		u.setUsername(username);
		u.setPassword(password);
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "update ERS_USERS set ERS_USERNAME = ?, ERS_PASSWORD = ?, USER_FIRST_NAME = ?,"
					+ "USER_LAST_NAME = ?, USER_EMAIL = ?  where ERS_USERS_ID = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(6, ID);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, email);
		
				
			success = ps.execute();	
				 
			
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		} 
	if(success) {
		return u;
	}else {
		return null;
	}
	}

	@Override
	public Users findUser(String username) {
		Users u = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_USERS INNER JOIN ERS_USER_ROLES ON (ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID) where ERS_USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("ERS_USERS_ID");
				String password = rs.getString("ERS_PASSWORD");
				String fname = rs.getString("USER_FIRST_NAME");
				String lname = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				Role role = Role.valueOf(rs.getString("USER_ROLE"));
				
				 u = new Users(ID, username, password, fname, lname, email, role);
				 
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
			log.catching(e);
		} 
	return u;
	}

	@Override
	public Boolean userExists(String username) {
		boolean exists = false;
			try(Connection con = ConnectionUtil.getConnectionFromFile()){
				String sql = "select * from ERS_USERS where ERS_USERNAME = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					exists = true;
				}
			}catch(SQLException | IOException e) {
				e.printStackTrace();
				log.catching(e);
			} 
		return exists;
	}

	@Override
	public Role userRole(String username) {
		Role role = null;
		int roleId = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_USERS where ERS_USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				roleId = rs.getInt("USER_ROLE_ID");
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		} 
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_USERS INNER JOIN ERS_USER_ROLES ON (ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID) where ERS_USER_ROLE_ID = ?";
			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setInt(1, roleId);
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				role = Role.valueOf(rs.getString("USER_ROLE"));
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
			log.catching(e);
		} 

		return role;
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> users = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_USERS INNER JOIN ERS_USER_ROLES ON (ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("ERS_USERS_ID");
				String username = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String fname = rs.getString("USER_FIRST_NAME");
				String lname = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				Role role = Role.valueOf(rs.getString("USER_ROLE"));
				
				 Users u = new Users(ID, username, password, fname, lname, email, role);
				 users.add(u);
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
			log.catching(e);
		} 
	return users;
}
	

//	@Override
//	public List<Users> getUsersManId(int Id) {
//		List<Users> users = new ArrayList<>();
//		try(Connection con = ConnectionUtil.getConnectionFromFile()){
//			String sql = "select * from ERS_USERS INNER JOIN ERS_USER_ROLES ON (ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID) where ";
//			PreparedStatement ps = con.prepareStatement(sql);
//			
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				int ID = rs.getInt("ERS_USERS_ID");
//				String username = rs.getString("ERS_USERNAME");
//				String password = rs.getString("ERS_PASSWORD");
//				String fname = rs.getString("USER_FIRST_NAME");
//				String lname = rs.getString("USER_LAST_NAME");
//				String email = rs.getString("USER_EMAIL");
//				Role role = Role.valueOf(rs.getString("USER_ROLE"));
//				
//				 Users u = new Users(ID, username, password, fname, lname, email, role);
//				 users.add(u);
//			}
//		}catch(SQLException | IOException e) {
//			e.printStackTrace();
//		} 
//	return users;
//}
		
	

	@Override
	public Users findUser(int ID) {
		Users u = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_USERS INNER JOIN ERS_USER_ROLES ON (ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID) where ERS_USERS_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String fname = rs.getString("USER_FIRST_NAME");
				String lname = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				Role role = Role.valueOf(rs.getString("USER_ROLE"));
				
				 u = new Users(ID, username, password, fname, lname, email, role);
				 
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
			log.catching(e);
		} 
	return u;
	}
	

}
