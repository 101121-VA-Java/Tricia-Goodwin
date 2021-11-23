package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.models.Bookseller;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.repositories.UsersPostgres;

@ExtendWith(MockitoExtension.class)
public class UserDaoTest {
	@Mock
	private UserDao ud;
	
	@InjectMocks
	private UserPostgres us;

	//static UserDao ud = new UsersPostgres();

	@BeforeAll
	public static void setup() {
		
	}
	@Order(1)
	@Test
	public void getCustomers() {
		List<User> u = new ArrayList<User>();
		u.add(new Customer(0, "test", "test", "test", "test", "test", 0));
		
		Mockito.when(ud.getAllCustomers()).thenReturn(u);
		List<User> actual = u;
		assertEquals(actual,ud.getAllCustomers());
	}
	
	@Order(2)
	@Test
	public void addCustomerValid() {
		Mockito.when(ud.addUser("Eileen", "Goodwin", "EVisle2", "Password", "Customer")).thenReturn(true);
		boolean actual = ud.addUser("Eileen", "Goodwin", "EVisle2", "Password", "Customer");
		boolean expected = ud.addUser("Eileen", "Goodwin", "EVisle2", "Password", "Customer");
		assertEquals(expected,actual);
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
