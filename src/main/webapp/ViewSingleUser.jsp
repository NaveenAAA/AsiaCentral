<%@include file="header.jsp" %>
<%@page import="impl.UserDAOImpl"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%
     UserDAO udao = new UserDAOImpl();

	request.setAttribute("User", udao.getUser( Integer.parseInt(request.getParameter("id")) ));
%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>Viewing User: ${User.getName()}</h1>

	<table class="table table-striped" style="font-size: 20px; font-weight: bold;">
		<tbody>

			
				
				
				<tr>
					<td>
					Name
					</td>
					<td>
					${User.getName()}
					</td>
					
				</tr>
				
				<tr>
					<td>
					Email
					</td>
					<td>
					${User.getEmail()}
					</td>
					
				</tr>
				
				<tr>
					<td>
					Phone
					</td>
					<td>
					${User.getPhone()}
					</td>
					
				</tr>

		</tbody>
	</table>

	
</body>
</html>