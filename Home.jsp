<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title </title>
<style>
body {
    background-color:red; /* Light blue background */
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1>HomePage</h1>
<form action="homepage" method="post">
<nav class="navbar" style="background-color: #e3f2fd;">
 <input type="submit" class="btn btn-dark"name="action"value="AddStudent">
 <input type="submit" class="btn btn-dark"name="action"value="Display">
 <input type="submit" class="btn btn-dark"name="action"value="Update">
 <input type="submit" class="btn btn-dark"name="action"value="Delete">
</nav>
</form>

</body>
</html>