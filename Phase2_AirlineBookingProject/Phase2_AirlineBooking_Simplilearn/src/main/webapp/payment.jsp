<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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
img{

margin : 0 auto;
display:block;
padding-bottom:10px;

}
</style>
</head>
<body>



	<div class="form">
		<form action="confirm.jsp">
				<h2 style="text-align:center;">Payment</h2>
			<h4 style="text-align:center;" >Scan QR to pay</h4>
			
			<img src="img/qr.png" width="300" height="300" >
		
			<input type="submit" value="Pay">
		</form>
	</div>
</body>
</html>