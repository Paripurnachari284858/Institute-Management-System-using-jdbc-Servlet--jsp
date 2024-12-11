<%@page import="com.project.Bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Home.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div align="center">
		<h1>UpdateStudentData</h1>
		
		<!-- <label>Enter Mobile Number</label><br><input type="number"name="mobile"><br><br>
<input type="submit"value="Update"><br><br> -->

		<form action="updatedata" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Enter
					Mobile Number</label> <input type="tel" class="form-control" name="mobile"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					style="width: 300px"> <input type="submit"class="btn btn-dark" value="Update">
					
					
					
			</div>
		</form>
	</div>
	
	
	<br>
	<br>
	<div align="center">
	<%if(request.getAttribute("messege")==("Mobile/Email is alredy Existed")){ %>
	<p style="color:red;"><%out.println(request.getAttribute("messege")); %></p><%} %>
	</div>
	
	
	<div align="center">
	<%if(request.getAttribute("messege")!=null && request.getAttribute("messege")!=("Mobile/Email is already Existed")){ %>
	<p style="color:green;"><%out.println(request.getAttribute("messege")); %></p><%} %>
	</div>
		<div align="center">
	<%StudentBean s=(StudentBean)request.getAttribute("studentdata");%>
	<% if(s!=null){ %>
	<form action="dataupdate"method="post">
	<input type="hidden"value="<%=s.getId() %>" name="id">
  <div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Name</label>
				 <input type="text" class="form-control" name="name"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					value="<%=s.getName()%>" style="width: 300px">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">
					Age</label>
					 <input type="number" class="form-control" name="age"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					style="width: 300px"value="<%=s.getAge()%>"> 
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">
					Mobile</label>
					 <input type="number" class="form-control" name="mobile"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					style="width: 300px"value="<%=s.getMobile()%>"> 
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">
					Address</label> 
					<input type="text" class="form-control" name="address"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					style="width: 300px"value="<%=s.getAddress()%>"> 
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">
					Email</label>
					 <input type="email" class="form-control" name="email"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					style="width: 300px"value="<%=s.getEmail()%>"> 
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">
					Course</label>
					 <input type="text" class="form-control" name="course"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					style="width: 300px"value="<%=s.getCourse() %>"> 
					 <input type="submit"
					class="btn btn-dark" value="Update">
			</div>
			</form>
			<%} %>
				</div>
</body>
</html>