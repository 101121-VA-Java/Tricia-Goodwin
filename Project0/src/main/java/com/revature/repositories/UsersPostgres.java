package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UsersPostgres implements UserDao{

	static Scanner sc = BooksScanner.getScanner();
	private static Logger log = LogManager.getRootLogger();

//	
	@Override
	public List<User> getAllCustomers() {
		String sql = "select * from customers;";
		List <User> customers = new ArrayList<>();

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("c_id");
				String fname = rs.getString("c_fname");
				String lname = rs.getString("c_lname");
				String username = rs.getString("c_username");
				String role = rs.getString("c_role");
				String password = rs.getString("c_password");
				int booksOwned = rs.getInt("c_books");

				
				Customer newCust = new Customer(id, fname, lname, username,role, password, booksOwned);

				customers.add(newCust);
			}

			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return customers;
	}
	


	@Override
	public boolean findCustomer(String username) throws UserNotFoundException {
		boolean found = false;
		String sql = "select * from booksellers where bs_username = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,username);
			
			ResultSet rs = ps.executeQuery();
			found = rs.next();
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return found;
	}
	
	public boolean findBookseller(String username) throws UserNotFoundException {
		boolean found = false;
		String sql = "select * from customers where c_username = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,username);
			
			ResultSet rs = ps.executeQuery();
			found = rs.next();
			
			
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return found;
	}

	@Override
	public Customer retrieveCustomer(String username) {
		User Cust = new Customer(null,null);
		String sql = "select * from customers where c_username = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,username);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("c_id");
				String fname = rs.getString("c_fname");
				String lname = rs.getString("c_lname");
				username = rs.getString("c_username");
				String role = rs.getString("c_role");
				String password = rs.getString("c_password");
				int booksOwned = rs.getInt("c_books");
				
				

				
				Cust = new Customer(id, fname, lname, username, role, password, booksOwned);

			}
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return (Customer) Cust;
	}
	
	@Override
	public Bookseller retrieveBookseller(String username) {
		User Bkseller = new Bookseller(null,null);
		String sql = "select * from booksellers where bs_username = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,username);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("bs_emp_id");
				String fname = rs.getString("bs_fname");
				String lname = rs.getString("bs_lname");
				username = rs.getString("bs_username");
				String password = rs.getString("bs_password");
				double hrly = rs.getDouble("bs_hrly");
				
				Bkseller = new Bookseller( id, fname, lname, username, password, hrly);

			}
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return (Bookseller) Bkseller;
	}

	@Override
	public boolean addUser(String fname, String lname, String username, String password, String role) {
		boolean executed = false;
		if(role.equals("Customer")) {
			
		String sql = "insert into customers (c_fname, c_lname, c_username, c_role, c_password, c_books) "
				+ "values (?, ?, ?, ?, ?, ?);";
		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, username);
			ps.setString(5, password);
			ps.setString(4, role);
			ps.setInt(6, 0);
			
			executed = ps.execute();
			log.info("Customer Account " + username + " has been created.");

			
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		}else{
				String sql = "insert into booksellers (bs_fname, bs_lname, bs_username, bs_role, bs_password, bs_hrly) "
						+ "values (?, ?, ?, ?, ?, ?);";
				
				try (Connection con = 
						ConnectionUtil.getConnectionFromFile()) {
					PreparedStatement ps = con.prepareStatement(sql);
					
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, username);
					ps.setString(4, "Admin");
					ps.setString(5, password);
					ps.setDouble(6, 16.00);
					
					executed = ps.execute();
					log.info("Bookseller Account " + username + " has been created.");

					
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				}
			}
		
		return executed;
	}


	@Override
	public List<User> getAllBooksellers() {
		String sql = "select * from booksellers;";
		List <User> booksellers = new ArrayList<>();

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("bs_emp_id");
				String fname = rs.getString("bs_fname");
				String lname = rs.getString("bs_lname");
				String username = rs.getString("bs_username");
				String password = rs.getString("bs_password");
				double hrlyRate = rs.getDouble("bs_hrly");
				

				
				Bookseller newBookseller = new Bookseller( id, fname,  lname,  username,  password,  hrlyRate);
				booksellers.add(newBookseller);
			}

			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return booksellers;
	}


	@Override
	public User getUserById(int id, String role) {
		User u = new Customer(null,null);
		if(role.equals("Customer")) {
			String sql = "select * from customers where c_id = ? ;";

			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setInt(1,id);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					String fname = rs.getString("c_fname");
					String lname = rs.getString("c_lname");
					String username = rs.getString("c_username");
					String password = rs.getString("c_password");
					
					

					
					u = new Customer( fname, lname, username, password);

				}
				
				
			}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return u;
		
		}else {
			User Bkseller = new Bookseller(null,null);
			String sql = "select * from booksellers where bs_emp_id = ? ;";

			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setInt(1,id);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String fname = rs.getString("bs_fname");
					String lname = rs.getString("bs_lname");
					String username = rs.getString("bs_username");
					String password = rs.getString("bs_password");
					Double hrly_rate = rs.getDouble("bs_hrly");

					
					Bkseller = new Bookseller( id, fname, lname, username, password, hrly_rate);

				}
				
				
			}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return (Bookseller) Bkseller;
		
		}
	}
	
	public boolean fireBookseller(String username) throws UserNotFoundException {
		boolean found = false;
		String sql = "delete from booksellers where bs_username = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,username);
			found = ps.execute();
			//found = rs.next();
			
			
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		log.info(username + " has been fired.");
		return found;
	}
	

	@Override
	public boolean updateBookseller(String username) {
		boolean updated = false;
		Bookseller bk = retrieveBookseller(username);
		int iD = bk.getId();
		String sql;
		System.out.println(bk);
		System.out.println("Update User:");
		System.out.println("1. First Name");
		System.out.println("2. Last Name");
		System.out.println("3. Password");
		System.out.println("4. Hourly Rate");
		System.out.println("5. Leave unchanged");
		String choice = sc.nextLine();
		switch(choice) {
		case "1":
			System.out.println("Enter new first name: ");
			String fname = sc.nextLine();
			sql = "Update Booksellers set bs_fname = ?  where bs_emp_id = ? ;";
			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1,fname);
				ps.setInt(2, iD);
				ps.execute();
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
			break;
		case "2":
			System.out.println("Enter new last name: ");
			String lname = sc.nextLine();
			sql = "Update Booksellers set bs_lname = ?  where bs_emp_id = ? ;";
			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1,lname);
				ps.setInt(2, iD);
				updated = ps.execute();
			}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;
		case "3":
			System.out.println("Enter new password: ");
			String password = sc.nextLine();
			sql = "Update Booksellers set bs_password = ?  where bs_emp_id = ? ;";
			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1,password);
				ps.setInt(2, iD);
				updated = ps.execute();
				
			}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;
		case "4":
			System.out.println("Enter new hourly rate(with no $ or /): ");
			double hrly = sc.nextDouble();
			sc.nextLine();
			sql = "Update Booksellers set bs_hrly = ?  where bs_emp_id = ? ;";
			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setDouble(1,hrly);
				ps.setInt(2, iD);
				updated = ps.execute();
			}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;
		case "5":
			break;
		default:
			System.out.println("Choice not registered");
		}
		log.info(username + " has been updated.");

		return updated;
		
	}
	

}
