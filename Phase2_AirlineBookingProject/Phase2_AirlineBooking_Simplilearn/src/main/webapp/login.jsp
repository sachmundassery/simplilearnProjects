<%@page import="com.airline.login.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.io.*,java.util.*,java.sql.*, com.mysql.jdbc.Driver"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<%
	Login login = new Login();

	String loginType = request.getParameter("loginType");
	if (loginType.equals("USER")) {

		String userEmail = request.getParameter("userEmail");
		String userPsw = request.getParameter("userPsw");
		Boolean userValidate = login.personLogin(loginType, userEmail, userPsw);
		if (userValidate == true) {
			
			
			
			/* request.getSession().setAttribute("userEmail", userEmail); */
			
			
			
			
			session.setAttribute("userEmail", userEmail);
			response.sendRedirect("flightSearch.jsp");
		} else {
			response.sendRedirect("userLogin.jsp");
		}

	} else {
		String adminEmail = request.getParameter("adminEmail");
		String adminPsw = request.getParameter("adminPsw");
		Boolean adminValidate = login.personLogin(loginType, adminEmail, adminPsw);
		if (adminValidate == true) {
			/* session.setAttribute("adminEmail", adminEmail); */
			request.getSession().setAttribute("adminEmail", adminEmail);
			request.getRequestDispatcher("changePassword.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("adminLogin.jsp");
		}

	}
	%>

</body>
</html>