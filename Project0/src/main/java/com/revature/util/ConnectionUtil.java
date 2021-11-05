package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static Connection con;

//	public static Connection getConnectionFromEnv() throws SQLException {
//		String url = System.getenv(Messages.getString("ConnectionUtil.0")); 
//		String username = System.getenv(Messages.getString("ConnectionUtil.1")); 
//		String password = System.getenv(Messages.getString("ConnectionUtil.2")); 
//		System.out.println(url);
//		System.out.println(username);
//		System.out.println(password);
//		
//		if (con == null || con.isClosed()) {
//			con = DriverManager.getConnection(url, username, password);
//		}
//		
//		return con;
//	}
	
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("prop.properties")); //$NON-NLS-1$
		
		String url = prop.getProperty("URL"); //$NON-NLS-1$

		String username = prop.getProperty("username"); //$NON-NLS-1$

		String password = prop.getProperty("password"); //$NON-NLS-1$

		
		if (con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		}
		
		return con;
	}
//	public static Connection getHardCodedConnection() throws SQLException {
//		String url = "jdbc:postgresql://database-1.cg5jlpjgdi39.us-east-2.rds.amazonaws.com:5432/postgres"; //$NON-NLS-1$
//		String username = "postgres"; //$NON-NLS-1$
//		String password = "patricia14"; //$NON-NLS-1$
//
//		/*
//		 * If Connection con is null or closed, we're creating a new connection 
//		 * otherwise we're returning an existing connection.
//		 */
//		if (con == null || con.isClosed()) {
//			con = DriverManager.getConnection(url, username, password);
//		}
//		return con;
//	}

}

