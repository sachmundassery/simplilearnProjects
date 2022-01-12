package com.airline.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection conn;

	public DatabaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinebooking", "root", "root");
		// attempts to establish a connection to the database by using the given database URL
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() throws SQLException {
		this.conn.close();
	}
}
