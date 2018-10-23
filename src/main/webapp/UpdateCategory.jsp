<%@include file="header.jsp" %>
<%@page import="impl.CategoryDAOImpl"%>
<%@page import="dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<%
CategoryDAO cdao = new CategoryDAOImpl();

request.setAttribute("category", cdao.getCategory( Integer.parseInt(request.getParameter("id")) ));

%>

<body style="margin: auto; width: 80%;">

<h1>Update Category</h1>

<form action="UpdateCategoryToDB" method="post">

	<input type="hidden" name="id" value="${category.getId()}">

	<input name="name" class="form-control" placeholder="Enter Category Name" value="${category.getName()}">
	<br>
	<input name="description" class="form-control" placeholder="Enter Category Description" value="${category.getDescription()}" >
	<br>
	<input type="submit" value="Submit" class="btn btn-primary">

</form>

</body>
</html>