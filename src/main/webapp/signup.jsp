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

h1.alert{
	font-size: 20px;
	box-shadow: 2px 2px 10px #333333;
}

</style>

</head>
<body style="margin: auto; width: 80%;">


	<h1>SignUp</h1>
	<br>

	<c:if test="${not empty errorMap}">
	
		<h1>Error</h1>
	
	</c:if>


	<form action="AddUser" method="post">

		<input name="name" class="form-control" placeholder="Enter User Name" value="${currentUser.getName()}">
		
		<c:if test="${not empty errorMap}">
	
			<c:forEach items="${errorMap.name}" var="errors">
				<h1 class="alert alert-danger">${errors}</h1>
			</c:forEach>
				
		</c:if>
		
		<br>
		<input type="password" name="password" class="form-control"
			placeholder="Enter Password ">
			<c:if test="${not empty errorMap}">
	
			<c:forEach items="${errorMap.password}" var="errors">
				<h1 class="alert alert-danger">${errors}</h1>
			</c:forEach>
			</c:if>
		<br>
		<input
			type="password" name="Cpassword" class="form-control"
			placeholder="Confirm password">
			<c:if test="${not empty errorMap}">
	
			<c:forEach items="${errorMap.cpassword}" var="errors">
				<h1 class="alert alert-danger">${errors}</h1>
			</c:forEach>
			</c:if>
		<br>
		<input type="email"
			name="email" class="form-control" placeholder="Email Address">
			<c:if test="${not empty errorMap}">
	
			<c:forEach items="${errorMap.email}" var="errors">
				<h1 class="alert alert-danger">${errors}</h1>
			</c:forEach>
			</c:if>
		<br>
		<input type="text" name="phone" class="form-control" value="${currentUser.getPhone()}" 
			placeholder="Phone">
		
		<c:if test="${not empty errorMap}">
	
			<c:forEach items="${errorMap.phone}" var="errors">
				<h1 class="alert alert-danger">${errors}</h1>
			</c:forEach>
				
		</c:if>
		
		<br> <input type="submit"
			value="Submit" class="btn btn-primary">



	</form>

</body>
</html>