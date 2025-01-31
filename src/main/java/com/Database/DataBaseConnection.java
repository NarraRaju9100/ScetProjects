package com.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private final static String url="jdbc:mysql://localhost:3306/autho";
	private final static String username="root";
	private final static String password="admin";
	
	
	public  static Connection getConnetion() throws SQLException, ClassNotFoundException {
		 Connection conn=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	 	DriverManager.getConnection(url, username, password);
	return conn;		
		
		
	}

}
