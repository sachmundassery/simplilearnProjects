<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
input[type=text] {
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
	border: 2px solid black;
	border-radius: 4px;
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
	margin: 2px 2px;
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
</style>
</head>
<body>

	<div class="form">
		<form action="passwordChangeAction.jsp" method="post">
			<input type="text" name="adminEmail" id="adminEmail"
				style="border: none; text-align: center; visibility: hidden;"
				value="${adminEmail}"> <input type="password" name="oldPassword"
				placeholder="Old Password"> <input type="password"
				name="newPassword" placeholder="New Password"> <input
				type="password" name="confirmNewPassword" placeholder="Confirm Password">
			<input type="submit" value="SUBMIT">
		</form>
	</div>
</body>
</html>