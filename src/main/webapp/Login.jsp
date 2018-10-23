<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">

/* h1.alert{
	font-size: 20px;
	box-shadow: 2px 2px 10px #333333;
} */

</style>

</head>
<body style="margin: auto; width: 80%;">


	<h1>Login</h1>
	<br>

	<form action="Login" method="post">

		<input name="name" class="form-control" placeholder="Enter User Name" value="${name}">
			
		<br>
		<input type="password" name="password" class="form-control"
			placeholder="Enter Password ">
			
		<br>
			
		<c:if test="${not empty error}">
		
		
		<h1 class="alert alert-danger">Invalid Credentials</h1>
		
		</c:if>
			
		<br> <input type="submit"
			value="Login" class="btn btn-success">



	</form>

</body>
</html>