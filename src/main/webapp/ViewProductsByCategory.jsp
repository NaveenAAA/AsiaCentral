<%@include file="header.jsp" %>
<%@page import="impl.CategoryDAOImpl"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="impl.ProductDAOImpl"%>
<%@page import="dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Products By Category</title>

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
 
    request.setAttribute("Products", pdao.getProductCat(Integer.parseInt(request.getParameter("category_id"))));

   CategoryDAO cdao = new CategoryDAOImpl();

	request.setAttribute("categories", cdao.getCategory(Integer.parseInt(request.getParameter("category_id"))));
	

%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>Products In this Category</h1>

	<table class="table table-striped" style="font-size: 20px; font-weight: bold;">
		<thead>

			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Description</td>
				<td>Category</td>
				<td>Price</td>
				<td>Image</td>
				
			</tr>


		</thead>
		<tbody> 

			<c:forEach var="x" items="${Products}">

				<tr>
					<td>${x.getId()}</td>
					<td>${x.getName()}</td>
					<td style="font-size:15px;">${x.getDescription()}</td>
					<td>${x.getCategory().getName()}</td>
					<td>${x.getPrice()}</td>
					 <td><img src="${x.getImagePath()}" style="max-width: 100px;" class="img img-thumbnail"/></td>
					
					
				</tr>

			</c:forEach>

		</tbody>
	</table>
<h1>Delete All Products</h1>

	 	<a href="DeleteProCat?category_id=${categories.getId()}" class="btn btn-danger">Delete</a> 

</body>
</html>