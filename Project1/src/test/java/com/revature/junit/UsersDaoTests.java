package com.revature.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.h2.tools.RunScript;
import com.revature.daos.DaoFactory;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.UsersDao;
import com.revature.models.Role;
import com.revature.models.Users;
import com.revature.services.ReimbursementService;
import com.revature.services.UsersService;
import com.revature.util.ConnectionUtil;



@ExtendWith(MockitoExtension.class)
public class UsersDaoTests {
	
	//private UsersDao ud = DaoFactory.getUsersDao();
	private static MockedStatic<ConnectionUtil> mockedConnectionUtil;
	private static Connection con;

		
		private static DaoFactory df = DaoFactory.getDaoFactory();
		@Mock
		private UsersDao ud = df.getUsersDao();
		private ReimbursementDao rd = df.getReimbursementDao();
		
		@InjectMocks
		private UsersService us;
		private ReimbursementService rs;
	
	@BeforeAll
	public static void setup() {
		mockedConnectionUtil = Mockito.mockStatic(ConnectionUtil.class);
		mockedConnectionUtil.when(ConnectionUtil::getConnectionFromFile)
			.then(I -> getH2Connection());
		
		
		}

	@AfterAll
	public static void end() {

		mockedConnectionUtil.close();
	}
//	
//	@BeforeEach
//	public void setUp() throws SQLException, IOException {
//		try(Connection c = ConnectionUtil.getConnectionFromFile()){
//			RunScript.execute(c, new FileReader("setup.sql"));
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
//	}
//	
//	@AfterEach
//	public void teardown() throws SQLException, IOException {
//		try(Connection c = ConnectionUtil.getConnectionFromFile()){
//			RunScript.execute(c, new FileReader("teardown.sql"));
//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void doesUserExistsInvalid() {
		Mockito.when(ud.userExists("username")).thenReturn(false);
		boolean expected = false;
		assertEquals(expected, ud.userExists("username"));
	}
	
	@Test
	public void doesUserExistsValid() {
		Mockito.when(ud.userExists("username")).thenReturn(true);
		boolean expected = true;
		assertEquals(expected, ud.userExists("username"));
	}
	
	@Test
	public void getUsersRole() {
		Mockito.when(ud.userRole("username")).thenReturn(EMPLOYEE);
		Role expected = EMPLOYEE;
		assertEquals(expected, ud.userRole("username"));
	}
	
	@Test
	Users addUser(String fname, String lname, String username, String password, String email, String role);
	
	
	@Test
	Users findUser(String username);
	
	
	
	
	
	
	
// Change this block of code
	public static Connection getH2Connection() {
		try {
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection("jdbc:h2:~/test");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
//Change this block of code
}
