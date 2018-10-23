<%@include file="header.jsp" %>
<%@page import="impl.CartDAOImpl"%>
<%@page import="dao.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	
	request.setAttribute("cartAddress",  kdao.getShippingAddBillingAddress(email) );
%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>
		Invoice:
		<%=request.getParameter("email")%></h1>

	<hr>
	
	<table class="table table-striped"
			style="font-size: 20px; font-weight: bold;">
			<tbody>

				<tr>
					<td>Ship To</td>
					<td><textarea disabled="disabled" class="form-control" name="shipTo"
							style="resize: none;" placeholder="Enter Shipping Address">${cartAddress[0]}</textarea>
					</td>

				</tr>

				<tr>
					<td>Bill To</td>
					<td><textarea disabled="disabled" class="form-control" name="billTo"
							style="resize: none;" placeholder="Enter Billing Address">${cartAddress[1]}</textarea>
					</td>

				</tr>
				
			</tbody>
		</table>

	<hr>

	<table class="table table-striped"
		style="font-size: 20px; font-weight: bold;">
		<thead>

			<tr>
				<td>Id</td>
				<td>Image</td>
				<td>Name</td>
				<td>Description</td>
				<td>Price</td>
				<td>Qty</td>
				<td>Total</td>
	
			</tr>


		</thead>
		<tbody>

			<c:forEach var="x" items="${cart}">

				<tr>
					<td>${x.getProduct().getId()}</td>

					<td><img src="${x.getProduct().getImagePath()}"
						class="img img-thumbnail" style="max-width: 150px;"></td>

					<td>${x.getProduct().getName()}</td>
					<td>${x.getProduct().getDescription()}</td>
					<td>${x.getProduct().getPrice()}</td>
					<td>${x.getQty()}</td>
					<td>${x.getQty() * x.getProduct().getPrice()}</td>
					<c:set var="gTotal"
						value="${gTotal + x.getQty() * x.getProduct().getPrice()}"></c:set>


				</tr>

			</c:forEach>


		</tbody>
	</table>
	<h1 style="float: right; margin-bottom: 100px;">Grand Total: ${gTotal}</h1>

	<br><br><br>

	<hr>

	<a href="ConfirmAddress.jsp?email=<%=request.getParameter("email")%>" class="btn btn-primary">Confirm Addresses</a>

	<a href="ConfirmOrder.jsp?email=<%=request.getParameter("email")%>"
		class="btn btn-danger" style="float: right;">Confirm Order</a>

	<br>
	<br>

	<br>
	<br>

</body>
</html>