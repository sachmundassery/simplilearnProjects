package com.airline.registeruser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dbconnection.DatabaseConnection;
import com.airline.flights.Flights;

public class RegisterUser {

	public RegisterUser() {
		super();
	}

	private String fullName;
	private String address;
	private int age;
	private String mobile;
	private String username;
	private String idType;
	private String idNumber;
	private String country;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void insertUser(String userEmail, String fullName, String address, int age, String mobile, String idType,
			String idNo, String country, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DatabaseConnection db;

		try {
			db = new DatabaseConnection();
			java.sql.Connection conn = db.getConnection();

			PreparedStatement ps = conn.prepareStatement(
					" insert into registeruser (userEmail, fullName, address, age, mobile, govtId, country,idType ) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, userEmail);
			ps.setString(2, fullName);
			ps.setString(3, address);
			ps.setInt(4, age);
			ps.setString(5, mobile);
			ps.setString(6, idType);
			ps.setString(7, country);
			ps.setString(8, idNo);

			ps.executeUpdate();

			PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM registeruser");
			ResultSet rs = ps1.executeQuery();

			RegisterUser registerUser = new RegisterUser();
			if (rs.next()) {
				System.out.println(rs.getString(2));
				registerUser.setUsername(rs.getString(1));
				registerUser.setFullName(rs.getString(2));
				registerUser.setAddress(rs.getString(3));
				registerUser.setAge(rs.getInt(4));
				registerUser.setMobile(rs.getString(5));

				registerUser.setIdType(rs.getString(6));
				registerUser.setCountry(rs.getString(7));

				registerUser.setIdNumber(rs.getString(8));

			}

			request.getSession().setAttribute("registeredUser", registerUser);
//			request.getRequestDispatcher("review.jsp").forward(request, response);
			response.sendRedirect("review.jsp");
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
