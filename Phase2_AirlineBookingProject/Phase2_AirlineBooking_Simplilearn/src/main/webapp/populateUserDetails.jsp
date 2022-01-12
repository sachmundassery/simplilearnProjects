<%@page import="com.airline.registeruser.RegisterUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String userEmail = request.getParameter("userEmail");
	String fullname = request.getParameter("fullName");
	String address = request.getParameter("address");
	int age = Integer.parseInt(request.getParameter("age"));
	String mobile = request.getParameter("mobile");
	String idType = request.getParameter("IdType");
	String idNo = request.getParameter("IdNo");
	String country = request.getParameter("country");

	RegisterUser registerUser = new RegisterUser();
	registerUser.insertUser(userEmail,fullname,address,age,mobile, idType,idNo, country,request, response);
	%>
</body>
</html>