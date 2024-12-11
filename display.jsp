<%@page import="com.project.Bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Home.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body><h1 align="center">Student Data 
</h1><br>
	<table class="table" align="center" border="1px">
		<tr>
		<th class="table-dark">Id</th>
			<th class="table-dark">Name</th>
			<th class="table-dark">Age</th>
			<th class="table-dark">Mobile</th>
			<th class="table-dark">Address</th>
			<th class="table-dark">Email</th>
			<th class="table-dark">Course</th>
		</tr>
		<tbody>
			
			<%ArrayList<StudentBean> al = (ArrayList<StudentBean>) request.getAttribute("studentdata");
			for(StudentBean s2:al){%>
          <tr>
          <td><%=s2.getId()%></td>
          <td><%=s2.getName()%></td>
          <td><%=s2.getAge()%></td>
          <td><%=s2.getMobile()%></td>
          <td><%=s2.getAddress()%></td>
          <td><%=s2.getEmail()%></td>
          <td><%=s2.getCourse()%></td>
          </tr>
          <%} %>
		</tbody>
	</table>
</body>
</html>


