<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background: black;
}

h1, h2, h4 {
	text-align: center;
	margin-top: 30px;
	color: white;
}

input[type=number] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid black;
	border-radius: 4px;
}

input[type=number]:focus {
	background-color: lightblue;
}

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
	top: 5%;
	left: 30%;
	right: 30%;
	bottom: 30%;
	margin: -10px 0 0 -10px;
}

textarea {
	width: 100%;
}
</style>
</head>
<body>


	<div class="form">
		<h2>Flight No: ${selectedFlight.flightNo}</h2>
		<h4>Flight: ${selectedFlight.airlineName}</h4>


		<p style="color: white;">Please fill in your personal details</p>
		<form action="populateUserDetails.jsp" method="POST">
			<input name = "userEmail" hidden type="text" value="${userEmail}"
				style="color: white;" /> <input type="text" name="fullName"
				placeholder="Full Name" />
			<textarea name="address" placeholder="Address"></textarea>
			<input name="age" type="number" placeholder="Age" /> <input
				name="mobile" type="text" placeholder="Mobile" />

			<label>Id Type</label>
			<select name="IdType" id="id" >
				<option value="Aadhar">Aadhar Card</option>
				<option value="License">Driving License</option>
				<option value="Voter">Voter Id</option>
				<option value="Pan">Pan Card</option>
			</select> <input type="text" name="IdNo" placeholder="Id Number" /> <input
				type="text" placeholder="Country" name="country" /><input
				type="submit" value="Register"  />
		</form>


	</div>

</body>
</html>