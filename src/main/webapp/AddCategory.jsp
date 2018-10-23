<%@include file="header.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body style="margin: auto; width: 80%;">

<h1>Add Category</h1>

<form action="AddCategory" method="post">

	<input name="name" class="form-control" placeholder="Enter Category Name">
	<c:if test="${not empty errorMap}">
	
			<c:forEach items="${errorMap.name}" var="errors">
				<h1 class="alert alert-danger">${errors}</h1>
			</c:forEach>
				
		</c:if>
	<br>
	<input name="description" class="form-control" placeholder="Enter Category Description" >
	<c:if test="${not empty errorMap}">
	
			<c:forEach items="${errorMap.description}" var="errors">
				<h1 class="alert alert-danger">${errors}</h1>
			</c:forEach>
			
	</c:if>
	<br>
	<input type="submit" value="Submit" class="btn btn-primary">

</form>

</body>
</html>