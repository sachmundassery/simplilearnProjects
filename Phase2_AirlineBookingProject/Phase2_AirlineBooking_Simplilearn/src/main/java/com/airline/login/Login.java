package com.airline.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.airline.dbconnection.DatabaseConnection;

import com.mysql.jdbc.Connection;

public class Login {
	
	public boolean personLogin(String loginType, String email, String password) {
		DatabaseConnection db;
		PreparedStatement ps;
		ResultSet rs;
		try {
			db = new DatabaseConnection();
			java.sql.Connection conn = db.getConnection();

			if (loginType.equals("USER")) {
				ps = conn.prepareStatement("SELECT * FROM userlogin WHERE userEmail= ? AND userPassword = ?");
				ps.setString(1, email);
				ps.setString(2, password);
				rs = ps.executeQuery();

				if (rs.next()) {
					System.out.println("True----------------------");
					return true;
				}
				
			}
			else {
				ps = conn.prepareStatement("SELECT * FROM adminlogin WHERE userEmail= ? AND userPassword = ?");
				ps.setString(1, email);
				ps.setString(2, password);
				rs = ps.executeQuery();

				if (rs.next()) {
					System.out.println("True----------------------");
					return true;
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
}
