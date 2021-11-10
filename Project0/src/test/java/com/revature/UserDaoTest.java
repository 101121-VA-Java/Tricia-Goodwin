package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UsersPostgres;

public class UserDaoTest {

	static UserDao ud = new UsersPostgres();

	@BeforeAll
	public static void setup() {
		
	}
	@Order(1)
	@Test
	public void getCustomers() {
		assertEquals(12,ud.getAllCustomers().size());
	}
	
	@Order(2)
	@Test
	public void addCustomerValid() {
		ud.addUser("Eileen", "Goodwin", "EVisle2", "Password", "Customer");
		assertEquals(13, ud.getAllCustomers().size());
	}
	
	@Order(3)
	@Test
	public void getBooksellers() {
		assertEquals(13,ud.getAllBooksellers().size());
	}
	
	@Order(4)
	@Test
	public void addBooksellerValid() {
		ud.addUser("Eileen", "Goodwin", "EVisle2", "Password", "Admin");
		assertEquals(13, ud.getAllCustomers().size());
	}
	

	
	
	@Order(5)
	@Test
	public void getUser() {
		User expected = new Bookseller(2, "Barn", "Mc Caughan", "bmccaughan1", "QH4dfIa", 12.98) ;

		User actual = ud.getUserById(2, "Admin");
		assertEquals(actual,expected);
	}
	
	@Order(6)
	@Test
	public void getBookseller() {
		Bookseller expected = new Bookseller(2, "Barn", "Mc Caughan", "bmccaughan1", "QH4dfIa", 12.98) ;

		Bookseller actual = ud.retrieveBookseller("bmccaughan1");
		assertEquals(actual,expected);
		
	}
	
	@Order(7)
	@Test
	public void getCustomer() {
		Customer expected = new Customer(8, "Sanders", "Asling", "sasling7", "Customer", "N6o4bQ4hJ", 0) ;

		User actual = ud.retrieveCustomer("sasling7");
		assertEquals(actual,expected);
		
	}
	
	@Order(8)
	@Test
	public void removeBookseller() {
		ud.fireBookseller("EVisle2");
		assertEquals(12, ud.getAllCustomers().size());
	}
	


}
