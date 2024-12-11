<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="Home.jsp" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body >
<div align="center">
<h1> Enter Student Data</h1>

<form action="savedata"method="post">
<!--  <label>Name    :</label><input type="text"name="name"><br><br>
<label>Age     :</label><input type="number"name="age"><br><br>
<label>Mobile  :</label><input type="number"name="mobile"><br><br>
<label>Address :</label><input type="text"name="address"><br><br>
<label>Email   :</label><input type="email"name="email"><br><br>
<label>Course  : </label><input type="text"name="course"><br><br>

-->

<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Name</label>
  <input type="text" class="form-control" id="exampleFormControlInput1" name="name" placeholder="Enter Student Name" style="width:400px">
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Age</label>
  <input type="number" class="form-control" id="exampleFormControlInput1" name="age"  placeholder="Enter Age" style="width:400px">
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Mobile</label>
  <input type="number" class="form-control" id="exampleFormControlInput1" name="mobile" placeholder="Enter Mobile" style="width:400px">
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Address</label>
  <input type="text" class="form-control" id="exampleFormControlInput1" name="address" placeholder="Enter Address" style="width:400px">
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Email</label>
  <input type="email" class="form-control" id="exampleFormControlInput1" name="email" placeholder="Enter Email" style="width:400px">
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Course</label>
  <input type="text" class="form-control" id="exampleFormControlInput1" name="course" placeholder="Enter Course" style="width:400px">
</div>

<%  if(request.getAttribute("result")!=null) 
   {
     	out.println(request.getAttribute("result"));
   }
%>
<br>
<input type="submit" class="btn btn-dark" value="Insert Student">

</form>
</div>
</body>
</html>