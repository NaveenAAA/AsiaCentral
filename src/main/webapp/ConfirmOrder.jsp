<%@include file="header.jsp" %>
<%@page import="impl.CartDAOImpl"%>
<%@page import="dao.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.hero-image {
  background-image: url("images/1.jpg");
  background-color: #cccccc;
  height: 1000px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

.hero-text {
  text-align: center;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
}
</style>
<title>View Cart</title>

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
	CartDAO kdao = new CartDAOImpl();

	String email = request.getParameter("email");

	request.setAttribute("cart", kdao.getCart(email));
%>
</head>
<body>
<div class="hero-image">

<div class="container" >
<div style="margin-top:500px;">
   <a href="product.jsp" class="btn btn-danger">Continue Shopping</a>
	<a style="margin-left:500px;                                                                                                                  k" href="DeleteCart?email=<%=request.getParameter("email")%>"
						class="btn btn-danger">Home</a>
						</div>
   </div>
</div>
	
</body>
</html>