package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Books;
import com.revature.models.Offer;
import com.revature.util.ConnectionUtil;


public class BooksPostgres implements BooksDao {
	
	private static Logger log = LogManager.getRootLogger();
	static Scanner sc = BooksScanner.getScanner();
	DecimalFormat numberFormat = new DecimalFormat("#.00");


	//@Override
	public List<Books> getAllBooks() {
		String sql = "select * from books;";
		List <Books> books = new ArrayList<>();

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String title = rs.getString("b_title");
				String author = rs.getString("b_author");
				long isbn =  rs.getLong("b_isbn");
				boolean released = rs.getBoolean("b_released");
				int stock = rs.getInt("b_stock");
				String genre = rs.getString("b_genre");
				double price = rs.getDouble("b_price");
				boolean hardcover = rs.getBoolean("b_hardcover");
				boolean nytb = rs.getBoolean("b_nytb");
				

				
				Books newBook = new Books(title, author, isbn, released, stock, genre, price, hardcover, nytb);
				books.add(newBook);
			}

			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return books;
	}

	
	

	
	@Override
	public Books getBookByTitle(String title) {

		Books newBook = new Books(title,null);
		String sql = "select * from books where b_title = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,title);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String author = rs.getString("b_author");
				boolean released = rs.getBoolean("b_released");
				int stock = rs.getInt("b_stock");
				long isbn = rs.getLong("b_isbn");
				String genre = rs.getString("b_genre");
				double price = rs.getDouble("b_price");
				boolean hardcover = rs.getBoolean("b_hardcover");
				boolean nytb = rs.getBoolean("b_nytb");
				

				
				newBook.setAuthor(author);
				newBook.setReleased(released);
				newBook.setStock(stock);
				newBook.setIsbn(isbn);
				newBook.setGenre(genre);
				newBook.setPrice(price);
				newBook.setHardcover(hardcover);
				newBook.setNytbestseller(nytb);
				
			}
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
			
		return newBook;

	}
	
	public double getPrice(long isbn) {
		double price = 0;
		String sql = "select * from books where b_isbn = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1,isbn);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				price = rs.getDouble("b_price");

			}
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return price;
	}

	@Override
	public Books getBookByISBN(long isbn) {
		Books newBook = new Books(null,null, isbn);
		String sql = "select * from books where b_isbn = ? ;";

		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1,isbn);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String title = rs.getString("b_title");
				String author = rs.getString("b_author");
				boolean released = rs.getBoolean("b_released");
				int stock = rs.getInt("b_stock");
				String genre = rs.getString("b_genre");
				double price = rs.getDouble("b_price");
				boolean hardcover = rs.getBoolean("b_hardcover");
				boolean nytb = rs.getBoolean("b_nytb");
				
				newBook.setTitle(title);
				newBook.setAuthor(author);
				newBook.setReleased(released);
				newBook.setStock(stock);
				newBook.setGenre(genre);
				newBook.setPrice(price);
				newBook.setHardcover(hardcover);
				newBook.setNytbestseller(nytb);
				
			}
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
			
		return newBook;
	}

	@Override
	public long addBook(Books b) {
		long isbn = 0L;
		String sql = "insert into books (b_title, b_author, b_isbn, b_released, b_stock, b_genre, b_price, b_hardcover, b_nytb) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setLong(3, b.getIsbn());
			ps.setBoolean(4, b.isReleased());
			ps.setInt(5, b.getStock());
			ps.setString(6, b.getGenre());
			ps.setDouble(7, b.getPrice());
			ps.setBoolean(8, b.isHardcover());
			ps.setBoolean(9, b.isNytbestseller());
			
			boolean executed = ps.execute();
			
			if (!executed){
				isbn = b.getIsbn();
			}
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return isbn;
	}

	@Override
	public String findBook(long isbn) {
		String location = "";
		String sql = "select * from books where b_isbn = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1,isbn);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String title = rs.getString("b_title");
				String author = rs.getString("b_author");
				boolean released = rs.getBoolean("b_released");
				int stock = rs.getInt("b_stock");
				String genre = rs.getString("b_genre");
				double price = rs.getDouble("b_price");
				boolean hardcover = rs.getBoolean("b_hardcover");
				boolean nytb = rs.getBoolean("b_nytb");
				

				
				Books newBook = new Books(title, author, isbn, released, stock, genre, price, hardcover, nytb);
				location = newBook.location();
			}
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
			
		return location;
	}

	@Override
	public String findBook(String title) {
		String location = "";
		String sql = "select * from books where b_title = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,title);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String author = rs.getString("b_author");
				boolean released = rs.getBoolean("b_released");
				int stock = rs.getInt("b_stock");
				long isbn = rs.getLong("b_isbn");
				String genre = rs.getString("b_genre");
				double price = rs.getDouble("b_price");
				boolean hardcover = rs.getBoolean("b_hardcover");
				boolean nytb = rs.getBoolean("b_nytb");
				

				
				Books newBook = new Books(title, author, isbn, released, stock, genre, price, hardcover, nytb);
				location = newBook.location();
			}
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
			
		return location;
	}


	@Override
	public List<Books> getAllBooksByAuthor() {
		Scanner sc = BooksScanner.getScanner();
		System.out.println("Author: ");
		String author = sc.nextLine();
			String sql = "select * from books where b_author = ?;";
			List <Books> books = new ArrayList<>();
			

			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, author);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					String title = rs.getString("b_title");
					long isbn =  rs.getLong("b_isbn");
					boolean released = rs.getBoolean("b_released");
					int stock = rs.getInt("b_stock");
					String genre = rs.getString("b_genre");
					double price = rs.getDouble("b_price");
					boolean hardcover = rs.getBoolean("b_hardcover");
					boolean nytb = rs.getBoolean("b_nytb");
					

					
					Books newBook = new Books(title, author, isbn, released, stock, genre, price, hardcover, nytb);
					books.add(newBook);
				}

				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			} 

			return books;

	}
	

	@Override
	public List<Books> getAllBooksByGenre() {
		Scanner sc = BooksScanner.getScanner();
		System.out.println("Genre: ");
		String genre = sc.nextLine();

			String sql = "select * from books where b_genre = ?;";
			List <Books> books = new ArrayList<>();
			

			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, genre);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					String title = rs.getString("b_title");
					long isbn =  rs.getLong("b_isbn");
					boolean released = rs.getBoolean("b_released");
					int stock = rs.getInt("b_stock");
					String author = rs.getString("b_author");
					double price = rs.getDouble("b_price");
					boolean hardcover = rs.getBoolean("b_hardcover");
					boolean nytb = rs.getBoolean("b_nytb");
					

					
					Books newBook = new Books(title, author, isbn, released, stock, genre, price, hardcover, nytb);
					books.add(newBook);
				}

				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			} 
			return books;

	}
	@Override
	public boolean offerBook(int Cust_id, long isbn) {
		boolean executed = false;
		if(getBookByISBN(isbn).canSell()) {
		String sql = "insert into offers (c_id, isbn, accepted, payed)"
				+ "values (?, ?, ?, ?);";
		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, Cust_id);
			ps.setLong(2, isbn);
			ps.setBoolean(3, false);
			ps.setBoolean(4, false);
			
			ps.execute();
			executed = true;
			

		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		log.info("Customer  " + Cust_id + " has made and offer on " + isbn);

			return executed;
		}else {
			System.out.println("I'm Sorry, that book is not available");
			return false;
		}
	}

	
	
	@Override
	public boolean pendingOffer(int Cust_id, long isbn) {
		boolean executed = false;
		String sql = "insert into offers (c_id, isbn, accepted, payed)"
				+ "values (?, ?, ?, ?);";
		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, Cust_id);
			ps.setLong(2, isbn);
			ps.setBoolean(3, false);
			ps.setBoolean(4, false);
			
			executed = ps.execute();
			

		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return executed;
	}
	
	
	@Override
	public boolean sellBook(int Cust_id, long isbn) {
		boolean executed = false;
		String sql = "insert into offers (c_id, isbn, accepted, payed)"
				+ "values (?, ?, ?, ?);";
		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, Cust_id);
			ps.setLong(2, isbn);
			ps.setBoolean(3, false);
			ps.setBoolean(4, false);
			
			executed = ps.execute();
			

		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return executed;
	}


	@Override
	public void listGenres() {
		String sql = "select b_genre from books;";
		LinkedHashSet <String> genres = new LinkedHashSet<>();

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				String genre = rs.getString("b_genre");

				
//				for(String g: genres){
//					if (genre.equals(g)) {
//						break;
//						
//					} else {
						genres.add(genre);
//					}
//				}
				
						
			}

			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		for(String g: genres){
			System.out.println(g);
		}
		
	}





	@Override
	public boolean deleteBook(Long isbn) {

		boolean found = false;
		String sql = "delete from books where b_isbn = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1,isbn);
			found = ps.execute();
			//found = rs.next();
			
			
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return found;	
		}
	
	
	
	@Override
	public boolean updateBook(long isbn) {

		boolean updated = false;

		String sql;
		System.out.println("Update Book:");
		System.out.println("1. Price");
		System.out.println("2. Stock");
		System.out.println("3. Leave unchanged");
		String choice = sc.nextLine();
		switch(choice) {
		case "1":
			System.out.println("Enter new price: ");
			double price = sc.nextDouble();
			sc.nextLine();
			sql = "Update Books set b_price = ?  where b_isbn = ? ;";
			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setDouble(1,price);
				ps.setLong(2, isbn);
				ps.execute();
				log.info("Price of " + isbn + " has been updated.");

			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
			break;
		case "2":
			System.out.println("Enter new stock: ");
			double stock = sc.nextInt();
			sc.nextLine();
			sql = "Update Books set b_stock = ?  where b_isbn = ? ;";
			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setDouble(1,stock);
				ps.setLong(2, isbn);
				ps.execute();
				log.info("Stock of " + isbn + " has been updated.");

			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		case "3":
			
			break;
		default:
			System.out.println("Choice not registered");
		}
		
		return updated;
		
	}
	
	@Override
	public void seeMyBooks(int ID) {
		List<Long> myBooks = new ArrayList<Long>();
		String sql = "select isbn from booksowned where c_id = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1,ID);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			
				long isbn = rs.getLong("isbn");
				myBooks.add(isbn);	
			}
			
			
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		for(Long book:myBooks) {
			System.out.println(getBookByISBN(book));
		}
		
		
		
	}

	@Override
	public void seeMyOffers(int ID) {
		double cost = 0;
		List<Offer> myOffers = new ArrayList<Offer>();
		String sql = "select * from offers where c_id = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1,ID);
			
			ResultSet rs = ps.executeQuery();

				
				while(rs.next()) {
					int id = rs.getInt("c_id");
					long isbn = rs.getLong("isbn");
					boolean accepted = rs.getBoolean("accepted");
					boolean payed = rs.getBoolean("payed");
					


					Offer newOffer = new Offer(id, isbn, accepted, payed);
					myOffers.add(newOffer);
				}

				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			} 
			

		
		for(Offer offer:myOffers) {
			System.out.println(offer);
			cost=cost+getPrice(offer.getIsbn());
		}

		System.out.println("Cost of all pending offers is: "+numberFormat.format(cost));
		
	}

	
	@Override
	public void seePendingOffers() {
		double cost = 0;
		List<Offer> allOffers = new ArrayList<Offer>();
		String sql = "select * from offers where accepted = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setBoolean(1,false);
			
			ResultSet rs = ps.executeQuery();

				
				while(rs.next()) {
					int id = rs.getInt("c_id");
					long isbn = rs.getLong("isbn");
					boolean accepted = rs.getBoolean("accepted");
					boolean payed = rs.getBoolean("payed");
					


					Offer newOffer = new Offer(id, isbn, accepted, payed);
					allOffers.add(newOffer);
				}

				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			} 
			

		
		for(Offer offer:allOffers) {
			System.out.println(offer);
			cost=cost+getPrice(offer.getIsbn());
		}
		System.out.println("Cost of all pending offers is: "+numberFormat.format(cost));
		
	}
	
	@Override
	public void seeAcceptedOffers() {
		double cost = 0;
		List<Offer> allOffers = new ArrayList<Offer>();
		String sql = "select * from offers where accepted = ? ;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setBoolean(1,true);
			
			ResultSet rs = ps.executeQuery();

				
				while(rs.next()) {
					int id = rs.getInt("c_id");
					long isbn = rs.getLong("isbn");
					boolean accepted = rs.getBoolean("accepted");
					boolean payed = rs.getBoolean("payed");
					


					Offer newOffer = new Offer(id, isbn, accepted, payed);
					allOffers.add(newOffer);
				}

				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			} 
			

		
		for(Offer offer:allOffers) {
			System.out.println(offer);
			cost=cost+getPrice(offer.getIsbn());
		}
		System.out.println("Cost of all accepted offers is: "+numberFormat.format(cost));
		
	}
	
	
	@Override
	public void acceptOffer(int ID, long isbn) {
		
		String sql = "select * from offers where c_id = ? and isbn = ?;";

		
		try (Connection con = 
				ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1,ID);
			ps.setLong(2, isbn);
			
			ResultSet rs = ps.executeQuery();

				
				while(rs.next()) {
					int id = rs.getInt("c_id");
					long isbns = rs.getLong("isbn");
					boolean accepted = rs.getBoolean("accepted");
					boolean payed = rs.getBoolean("payed");
					


					Offer newOffer = new Offer(id, isbns, accepted, payed);
					System.out.println(newOffer);
				}

				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			} 
		System.out.println("Accept Offer?(y/n)");
		String yn = sc.nextLine();
		if(yn.equals("y")||yn.equals("Y")) {
			String sql2 = "Update offers set accepted = true where c_id = ? and isbn = ?;";

			
			try (Connection con = 
					ConnectionUtil.getConnectionFromFile()) {
				PreparedStatement ps = con.prepareStatement(sql2);
				
				ps.setInt(1,ID);
				ps.setLong(2, isbn);
				
				ps.execute();
				
				log.info("Customer  " + ID + " has had an offer on " + isbn + " accepted.");

					System.out.println("Offer has been accepted");
					sql = "Update Books set b_stock = (b_stock-1)  where b_isbn = ? ;";
					String sql1 = "Select * from Books where b_isbn = ?;";
				
						PreparedStatement ps1 = con.prepareStatement(sql);
						PreparedStatement ps2 = con.prepareStatement(sql1);
						
						ps1.setLong(1, isbn);
						ps1.execute();
						
						ps2.setLong(1,isbn);
						ResultSet rs2 = ps2.executeQuery();
						while(rs2.next()) {
						int newStock = rs2.getInt("b_stock");
						
						if(newStock==0) {
							String sql3 = "Delete from Offers where b_isbn = ?;";
							
							PreparedStatement ps3 = con.prepareStatement(sql3);
							ps3.setLong(1, isbn);
							
							ps3.execute();
						}
						}

									
				} catch (SQLException | IOException e) {
					e.printStackTrace();
				} 
		}
		
	}

}
