<%@include file="header.jsp" %>
<%@page import="impl.UserDAOImpl"%>
<%@page import="dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%

 UserDAO udao = new UserDAOImpl();

request.setAttribute("user" , udao.getUser(Integer.parseInt(request.getParameter("id"))) );

%>

</head>
<body style="margin: auto; width: 80%;">

	<h1>Update Users</h1>
	
	<form method="post" action="UpdateUser">

            <input type="hidden" value="${user.getId()}" name="id">
        
        <table class="table table-striped">
            
            <tbody>
                <tr>
                    <td style="font-family: 'Slabo 27px', serif; font-size: 28px;"> <i><b>Id:</b></i> </td>
                    <td style="font-family: 'Open Sans Condensed', sans-serif; font-size: 28px;"> <b>${user.getId()}</b> </td>
                </tr>
                <tr>
                    <td style="font-family: 'Slabo 27px', serif; font-size: 28px;"> <i><b>Name:</b></i> </td>
                    <td style="font-family: 'Open Sans Condensed', sans-serif; font-size: 28px;"> 
                        <b>
                            <input type="text" placeholder="Enter Username" class="form-control" value="${user.getName()}" name="name"/> 
                        </b>
                    </td>
                </tr>
                 <tr>
                    <td style="font-family: 'Slabo 27px', serif; font-size: 28px;"> <i><b>Password:</b></i> </td>
                    <td style="font-family: 'Open Sans Condensed', sans-serif; font-size: 28px;"> 
                        <b>
                            <input type="text" placeholder="Enter Password" class="form-control" value="${user.getPassword()}" name="password"/> 
                        </b>
                    </td>
                </tr>
              
                <tr>
                    <td style="font-family: 'Slabo 27px', serif; font-size: 28px;"> <i><b>Email:</b></i> </td>
                    <td style="font-family: 'Open Sans Condensed', sans-serif; font-size: 28px;"> <b>${user.getEmail()}</b> </td>
                 <input type="hidden" lass="form-control" value="${user.getEmail()}" name="email"/>
                </tr>
                <tr>
                    <td style="font-family: 'Slabo 27px', serif; font-size: 28px;"> <i><b>Phone:</b></i> </td>
                    <td style="font-family: 'Open Sans Condensed', sans-serif; font-size: 28px;">
                        <b>
                            <input type="phone" placeholder="Enter Phone" class="form-control" value="${user.getPhone()}" name="phone"/>
                        </b>
                    </td>
                </tr>
               
                 <tr>
                    <td style="font-family: 'Open Sans Condensed', sans-serif; font-size: 28px;">
                        <input type="submit" value="Update" class="btn btn-success"/>
                    </td>
                </tr>
            </tbody>
            
        </table>
        </form>
	
	 

</body>
</html>