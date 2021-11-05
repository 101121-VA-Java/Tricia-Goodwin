package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Books;
import com.revature.util.ConnectionUtil;
import com.revature.repositories.BooksScanner;


public class BooksPostgres implements BooksDao {

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

}
