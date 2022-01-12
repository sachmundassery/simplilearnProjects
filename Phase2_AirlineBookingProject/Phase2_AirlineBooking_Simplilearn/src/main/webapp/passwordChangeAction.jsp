<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.airline.dbconnection.DatabaseConnection"%>
	<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
			String newPassword = request.getParameter("newPassword");
			String confirmNewPasword = request.getParameter("confirmNewPassword");
			String adminEmail = request.getParameter("adminEmail");
			/* String adminEmail =request.getSession().getAttribute("adminEmail"); */
			 
			
			if (newPassword.equals(confirmNewPasword)){
				DatabaseConnection db;
				db = new DatabaseConnection();
				java.sql.Connection conn = db.getConnection();
				Statement stmt  = conn.createStatement();
				int rows = stmt.executeUpdate("update adminlogin set userPassword ='"+ newPassword+"' WHERE userEmail= '"+adminEmail+"' ");
				
				if (rows !=0){
					out.println("Password resetted successfully");
				}
				else{
					
					response.sendRedirect("changePassword.jsp");
				} 
			}
			else{
				out.println("Passwords not matching");
				response.sendRedirect("changePassword.jsp");
			}
	%>

</body>
</html>