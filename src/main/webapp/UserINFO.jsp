<%@include file="header.jsp" %>
<%@page import="impl.UserDAOImpl"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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

	request.setAttribute("user", udao.getUser());

	//request.setAttribute("users", udao.getProduct());
%>

</head>
<body style="margin: auto; width: 80%;">
    <h1>All Users</h1>

	<table class="table table-striped">

		<thead>

			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Password</td>
				<!--  <td>Confirm Password</td> -->
				<td>Email</td>
				<td>Phone</td>
				<!-- <td>View</td> -->

				<c:if test="${sessionScope.role == 'ROLE_ADMIN'}">
					<td>Update</td>
					<td>Delete</td>
				</c:if>

			</tr>

		</thead>

		<tbody>

			<c:forEach items="${user}" var="x">
				<tr>
					<td>${x.getId()}</td>
					<td>${x.getName()}</td>
					<td>${x.getPassword()}</td>
					<%--  <td>${x.getCpassword()}</td> --%>
					<td>${x.getEmail()}</td>
					<td>${x.getPhone()}</td>
					<%--     <td><a href="ViewUser.jsp?id=${x.getId()}" class="btn btn-primary">View</a></td>--%>

					<c:if test="${sessionScope.role == 'ROLE_ADMIN'}">
						<td><a href="UpdateUser.jsp?id=${x.getId()}"
							class="btn btn-success">Update</a></td>
						<td><a href="DeleteUser?id=${x.getId()}"
							class="btn btn-danger">Delete</a></td>
					</c:if>


				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>