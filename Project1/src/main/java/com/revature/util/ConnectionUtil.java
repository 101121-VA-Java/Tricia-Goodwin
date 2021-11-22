package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static Connection con;

	
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
}
