package com.airline.flights;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dbconnection.DatabaseConnection;

public class Flights {
	HttpServletRequest request;
	HttpServletResponse response;

	private int flightNo;
	private String airlineName;
	private String flightClass;
	private String leavingFrom;
	private String goingTo;
	private String departureTime;
	private String arrivalTime;
	private int totalSeats;
	private int bookedSeats;
	private int availableSeats;
	private String dateOfTravel;
	private int price;

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getLeavingFrom() {
		return leavingFrom;
	}

	public void setLeavingFrom(String leavingFrom) {
		this.leavingFrom = leavingFrom;
	}

	public String getGoingTo() {
		return goingTo;
	}

	public void setGoingTo(String goingTo) {
		this.goingTo = goingTo;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(String dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/*
	 * public void fetchFlights(String dateOfTravel, String from, String to, int
	 * noOfPassengers, HttpServletRequest request, HttpServletResponse response)
	 * throws javax.servlet.ServletException, IOException {
	 * 
	 * DatabaseConnection db; PreparedStatement ps; ResultSet rs;
	 * System.out.println(dateOfTravel + "----" + from + "---------" + to);
	 * Map<Integer, Flights> flights = new HashMap<Integer, Flights>(); try { db =
	 * new DatabaseConnection(); java.sql.Connection conn = db.getConnection();
	 * 
	 * ps = conn.prepareStatement(
	 * "SELECT * FROM flights WHERE dateOfTravel= ? AND leavingFrom = ? AND  goingTo = ?"
	 * ); ps.setString(1, dateOfTravel); ps.setString(2, from); ps.setString(3, to);
	 * rs = ps.executeQuery();
	 * 
	 * while (rs.next()) {
	 * 
	 * Flights flight = new Flights(); flight.setFlightNo(rs.getInt(1));
	 * flight.setAirlineName(rs.getString(2));
	 * flight.setFlightClass(rs.getString(3));
	 * flight.setLeavingFrom(rs.getString(4)); flight.setGoingTo(rs.getString(5));
	 * 
	 * flight.setDepartureTime(rs.getString(6));
	 * flight.setArrivalTime(rs.getString(7));
	 * 
	 * flight.setTotalSeats(rs.getInt(8)); flight.setBookedSeats(rs.getInt(9));
	 * flight.setAvailableSeats(rs.getInt(10));
	 * flight.setDateOfTravel(rs.getString(11)); flight.setPrice(rs.getInt(12));
	 * flights.put(flight.getFlightNo(), flight);
	 * 
	 * }
	 * 
	 * request.getSession().setAttribute("noOfPassengers", noOfPassengers);
	 * request.getSession().setAttribute("flights", flights);
	 * request.getSession().setAttribute("flightList", new
	 * ArrayList<>(flights.values()));
	 * 
	 * request.getRequestDispatcher("flightResults.jsp").forward(request, response);
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * }
	 */
	public void fetchFlights(String dateOfTravel, String from, String to, int noOfPassengers,
			HttpServletRequest request, HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {

		DatabaseConnection db;
		PreparedStatement ps;
		ResultSet rs;
		System.out.println(dateOfTravel + "----" + from + "---------" + to);
		List< Flights> flights = new ArrayList<Flights>();
		try {
			db = new DatabaseConnection();
			java.sql.Connection conn = db.getConnection();

			ps = conn.prepareStatement(
					"SELECT * FROM flights WHERE dateOfTravel= ? AND leavingFrom = ? AND  goingTo = ?");
			ps.setString(1, dateOfTravel);
			ps.setString(2, from);
			ps.setString(3, to);
			rs = ps.executeQuery();

			while (rs.next()) {

				Flights flight = new Flights();
				flight.setFlightNo(rs.getInt(1));
				flight.setAirlineName(rs.getString(2));
				flight.setFlightClass(rs.getString(3));
				flight.setLeavingFrom(rs.getString(4));
				flight.setGoingTo(rs.getString(5));

				flight.setDepartureTime(rs.getString(6));
				flight.setArrivalTime(rs.getString(7));

				flight.setTotalSeats(rs.getInt(8));
				flight.setBookedSeats(rs.getInt(9));
				flight.setAvailableSeats(rs.getInt(10));
				flight.setDateOfTravel(rs.getString(11));
				flight.setPrice(rs.getInt(12));
				flights.add(flight);

			}

			request.getSession().setAttribute("noOfPassengers", noOfPassengers);
			request.getSession().setAttribute("flightList", flights);
			
			request.getRequestDispatcher("flightResults.jsp").forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fetchSelectedFlight(int selectedFlightNo, HttpServletRequest request, HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {
		DatabaseConnection db;
		PreparedStatement ps;
		ResultSet rs;

		try {
			db = new DatabaseConnection();
			java.sql.Connection conn = db.getConnection();

			
			ps = conn.prepareStatement("SELECT * FROM flights WHERE flightNo= ? ");
			ps.setInt(1, selectedFlightNo);

			rs = ps.executeQuery();
			
			//.out.println("---------^^^^^^^-------"+rs.getString(2));
			Flights selectedFlight = new Flights();
			if (rs.next()) {
				System.out.println(rs.getString(2));
				selectedFlight.setFlightNo(rs.getInt(1));
				selectedFlight.setAirlineName(rs.getString(2));
				selectedFlight.setFlightClass(rs.getString(3));
				selectedFlight.setLeavingFrom(rs.getString(4));
				selectedFlight.setGoingTo(rs.getString(5));

				selectedFlight.setDepartureTime(rs.getString(6));
				selectedFlight.setArrivalTime(rs.getString(7));

				selectedFlight.setTotalSeats(rs.getInt(8));
				selectedFlight.setBookedSeats(rs.getInt(9));
				selectedFlight.setAvailableSeats(rs.getInt(10));
				selectedFlight.setDateOfTravel(rs.getString(11));
				selectedFlight.setPrice(rs.getInt(12));
				

			}

			request.getSession().setAttribute("selectedFlight", selectedFlight);
			request.getSession().setAttribute("flightNo", selectedFlight.flightNo);

			request.getRequestDispatcher("register.jsp").forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
