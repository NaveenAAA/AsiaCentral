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
	String email = request.getParameter("email");

	request.setAttribute("email", email);

	CartDAO kdao = new CartDAOImpl();
	request.setAttribute("cartAddress",  kdao.getShippingAddBillingAddress(email) );
%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>
		Confirm Addresses:
		<%=request.getParameter("email")%></h1>

	<hr>

	<form action="UpdateShippingAndBillingAddress" method="post">

		<input type="hidden" value="${email}" name="email">

		<table class="table table-striped"
			style="font-size: 20px; font-weight: bold;">
			<tbody>

				<tr>
					<td>Ship To</td>
					<td><textarea class="form-control" name="shipTo"
							style="resize: none;" placeholder="Enter Shipping Address">${cartAddress[0]}</textarea>
					</td>

				</tr>

				<tr>
					<td>Bill To</td>
					<td><textarea class="form-control" name="billTo"
							style="resize: none;" placeholder="Enter Billing Address">${cartAddress[1]}</textarea>
					</td>

				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Save"
						class="btn btn-success"></td>

				</tr>

			</tbody>
		</table>
	</form>
	<hr>

	<a href="ViewCart.jsp?email=${email}" class="btn btn-primary">Back
		To Cart</a>

	<a href="ViewInvoice.jsp?email=<%=request.getParameter("email")%>"
		class="btn btn-danger" style="float: right;">View Invoice</a>

	<br>
	<br>

	<br>
	<br>

</body>
</html>