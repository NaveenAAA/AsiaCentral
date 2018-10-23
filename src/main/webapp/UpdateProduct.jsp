<%@include file="header.jsp" %>
<%@page import="impl.ProductDAOImpl"%>
<%@page import="dao.ProductDAO"%>
<%@page import="impl.CategoryDAOImpl"%>
<%@page import="dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<%
ProductDAO pdao = new ProductDAOImpl();

request.setAttribute("product", pdao.getProduct( Integer.parseInt(request.getParameter("id")) ));

%>

<body style="margin: auto; width: 80%;">

<h1>Update Product</h1>

<form action="UpdateProductToDB" method="post">

	<input type="hidden" name="id" value="${product.getId()}">
	<input type="hidden" name="imagepath" value="${product.getImagePath()}">
    <input type="hidden" name="cat" value="${product.getCategory().getId()}">
	<input name="name" class="form-control" placeholder="Enter Product Name" value="${product.getName()}">
	<br>
	<input name="description" class="form-control" placeholder="Enter Product Description" value="${product.getDescription()}" >
	<br>
	<input name="price" class="form-control" placeholder="Enter Product Price" value="${product.getPrice()}">
	<br>
	
	<input type="submit" value="Submit" class="btn btn-primary">

</form>

</body>
</html>