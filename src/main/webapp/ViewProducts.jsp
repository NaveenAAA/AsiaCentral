<%@include file="header.jsp" %>
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

	request.setAttribute("Products", pdao.getProduct());
%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>View Products</h1>

	<table class="table table-striped" style="font-size: 20px; font-weight: bold;">
		<thead>

			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Description</td>
				<td>Category</td>
				<td>Price</td>
				<td>Image</td>
				
				
				<td>View</td>
				
				<c:if test="${sessionScope.role == 'ROLE_ADMIN'}">
					<td>Update</td>
					<td>Delete</td>
				</c:if>
			</tr>


		</thead>
		<tbody>

			<c:forEach var="x" items="${Products}">

				<tr>
					<td>${x.getId()}</td>
					<td>${x.getName()}</td>
					<td>${x.getDescription()}</td>
					<td>${x.getCategory().getName()}</td>
					<td>${x.getPrice()}</td>
					 <td><img src="${x.getImagePath()}" style="max-width: 100px;" class="img img-thumbnail"/></td>
					
					<td><a href="ViewSingleProduct.jsp?id=${x.getId()}" class="btn btn-primary">View</a></td>
					<c:if test="${sessionScope.role == 'ROLE_ADMIN'}">
					<td><a href="UpdateProduct.jsp?id=${x.getId()}" class="btn btn-success">Update</a></td>
					<td><a href="DeleteProduct?id=${x.getId()}" class="btn btn-danger">Delete</a></td>
				</c:if>
				</tr>

			</c:forEach>

		</tbody>
	</table>

</body>
</html>