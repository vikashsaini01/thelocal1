package com.locals.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class SqlConnection {

	static Connection connection =  null ;
	static Logger logger = Logger.getLogger(SqlConnection.class);
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {

		}
	}

	public static Connection getConnection() throws Exception {
		if(connection == null || connection.isClosed()) 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/locals", "root", "root");
		return connection;
	}
}
