<%@include file="header.jsp" %>
<%@page import="impl.CartDAOImpl"%>
<%@page import="dao.CartDAO"%>
<%@page import="impl.ProductDAOImpl"%>
<%@page import="dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products</title>

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
	ProductDAO pdao = new ProductDAOImpl();

	request.setAttribute("Product", pdao.getProduct(Integer.parseInt(request.getParameter("id"))));
%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>Viewing Product: ${Product.getName()}</h1>

	<table class="table table-striped"
		style="font-size: 20px; font-weight: bold;">
		<tbody>


			<tr>
				<td colspan="2">
					<center>
						<img src="${Product.getImagePath()}" style="max-width: 500px;"
							class="img img-thumbnail" />
					</center>
				</td>

			</tr>

			<tr>
				<td>Name</td>
				<td>${Product.getName()}</td>

			</tr>

			<tr>
				<td>Description</td>
				<td>${Product.getDescription()}</td>

			</tr>

			<tr>
				<td>Price</td>
				<td>${Product.getPrice()}</td>

			</tr>

		</tbody>
	</table>
	<c:if test="${not empty error}">
	<h1 class="alert alert-danger">Invalid Input</h1>
	</c:if>

	<form action="AddCart" method="post">

		<input type="hidden" value="${Product.getId()}" name="pid">
		 <input type="number" name="qty" class="form-control" placeholder="Enter Qty">
		
			
	
		<br> 
		<input type="email" name="email" class="form-control"placeholder="Enter Email" value="${loggedInUserEmail}"> 
		
		<br> <a href="ViewCart.jsp"
			class="btn btn-primary">view</a> <input type="submit" value="Submit"
			class="btn btn-primary">
	</form>
</body>
</html>