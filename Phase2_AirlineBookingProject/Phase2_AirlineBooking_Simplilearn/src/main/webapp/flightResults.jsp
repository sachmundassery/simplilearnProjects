<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#flightTable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  color:white;
}

#flightTable td, #flightTable th {
  border: 1px solid #ddd;
  padding: 8px;
 
  
}

#flightTable tr:nth-child(even){background-color: #f2f2f2;}

#flightTable tr:hover {background-color: #ddd;}

#flightTable th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
body{
	background-color: black;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${flights.isEmpty()}">
			<p>Sorry, no flights available according to search criteria.</p>
			<a href="flightSearch.jsp">Go back</a>
		</c:when>
		<c:otherwise>
			<table style="border: 1px solid black;" id="flightTable">
				<tr style="text-align: center;">
					<th>Flight Number</th>
					<th>Airline Name</th>
					<th>Class</th>
					<th>Leaving From</th>
					<th>Going To</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Total Seats</th>
					<th>Booked Seats</th>
					<th>Seat Availability</th>
					<th>Travel Date</th>
					<th>Price</th>
				</tr>

				<%-- <c:forEach var="object" items="${flightList}">
					<tr>
						<c:forEach var="field" items="${object['class'].declaredFields}">
							<c:catch>
								
									<c:choose>
										<c:when test="${field.name == 'flightNo' }">
										<td style="padding: 15px; text-align: center;">
											<c:set var="flightNumberLink" value="selectedFlight.jsp?value=${object.flightNo}" />
												<a href="${flightNumberLink}">${object.flightNo}</a>
												</td>
											</c:when>
										<c:otherwise>
										<td style="padding: 15px; text-align: center;">
											${object[field.name]}
											</td>
										</c:otherwise>
									</c:choose>
								
							</c:catch>
						</c:forEach>
					</tr>
				</c:forEach> --%>
				<c:forEach var="flight" items="${flightList}">
					<tr style="text-align:center; width:100%; margin: 0px auto;">
						<td><a href= "selectedFlight.jsp?value=${flight.flightNo}">${flight.flightNo}</a></td>
						<td>${flight.airlineName}</td>
						<td>${flight.flightClass}</td>	
						<td>${flight.leavingFrom}</td>
						<td>${flight.goingTo}</td>
						<td>${flight.departureTime}</td>
						<td>${flight.arrivalTime}</td>
						<td>${flight.totalSeats}</td>
						<td>${flight.bookedSeats}</td>
						<td>${flight.availableSeats}</td>
						<td>${flight.dateOfTravel}</td>
						<td>${flight.price}</td>
						
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>