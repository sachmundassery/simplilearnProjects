<%@page import="com.airline.flights.Flights"%>
<%@page import="com.airline.dbconnection.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
	String dateOfTravel = request.getParameter("date");
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	int noOfPassengers = Integer.parseInt(request.getParameter("noOfPassengers"));
	
	Flights flight = new Flights();
	flight.fetchFlights(dateOfTravel,from,to,noOfPassengers, request,response);
	

	%>
</body>
</html>