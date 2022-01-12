<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In.</title>
<style>
body {
	background: black;
}

input[type=email] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid black;
	border-radius: 4px;
}

input[type=text]:focus {
	background-color: lightblue;
}

input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
}

input[type=password]:focus {
	background-color: lightblue;
}

input[type=submit] {
	border: 2px solid black;
	color: black;
	padding: 16px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
	width: 100%;
	border-radius: 8px;
}

input[type=submit]:hover {
	background-color: #4CAF50; /* Green */
	color: white;
}

.form {
	position: absolute;
	top: 30%;
	left: 30%;
	right: 30%;
	bottom: 30%;
	margin: -10px 0 0 -10px;
}

h3 {
	color: white;
}
</style>
</head>
<body>

	<div class="form">
		<h3>Admin Login</h3>
		<form action="login.jsp" method="post">
			<input type="radio" id="loginType" name="loginType" value="ADMIN"
				checked="checked"
				style="border: none; text-align: center; visibility: hidden;">
			<input type="email" name="adminEmail" placeholder="E-MAIL"> <input
				type="password" name="adminPsw" placeholder="PASSWORD"> <input
				type="submit" value="SUBMIT">
		</form>
	</div>
</body>
</html>