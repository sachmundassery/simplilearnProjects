<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{
background: black;
}
h1 {
	text-align: center;
	margin-top: 150px;
	color:white;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 16px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
	width:175%;
	border-radius: 8px;
}
.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
}

.button1:hover {
	background-color: #4CAF50; /* Green */
	color: white;
}

.form {
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -100px 0 0 -100px;
}
</style>
<title>ABS</title>
</head>
<body>
	<h1>AIRLINE BOOKING SYSTEM</h1>
	<div class="form">
		<form action="userLogin.jsp" method="post">
			<button class="button button1">User</button>
		</form>
		<form action="adminLogin.jsp" method="post">
			<button class="button button1">Admin</button>
		</form>
	</div>
</body>
</html>