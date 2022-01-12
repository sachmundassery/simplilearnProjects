<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.airline.dbconnection.DatabaseConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.form {
	position: absolute;
	top: 15%;
	left: 30%;
	right: 30%;
	bottom: 30%;
	margin: -10px 0 0 -10px;
	border: 1px solid white;
}

body {
	background: black;
}

h1, h2, h4 {
	text-align: center;
	margin-top: 30px;
	color: white;
}
</style>
</head>
<body>

	<div class="form">
		<h2>Tickets Booked</h2>
		<br>
		<h4>Thankyou ${registeredUser.fullName} for using our service.</h4>

	</div>

	<%

	DatabaseConnection db;
	db = new DatabaseConnection();
	java.sql.Connection conn = db.getConnection();
	Statement stmt = conn.createStatement();
	int rows = stmt.executeUpdate("insert into booking (userEmail, flightNo)values('" + request.getSession().getAttribute("userEmail") + "','"
			+ request.getSession().getAttribute("flightNo") + "') ");

	%>
</body>
</html>