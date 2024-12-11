<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    body {
        background-color: #e3f2fd; /* Light blue background */
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        color: #333; /* Dark text color */
    }

    form {
        background-color: #ffffff;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 12px 24px rgba(0, 0, 0, 0.15); /* Soft shadow */
        width: 100%;
        max-width: 400px; /* Limit the form width */
        text-align: center;
    }

    h1 {
        font-size: 26px;
        color: #01579b; /* Dark blue heading */
        margin-bottom: 30px;
    }

    label {
        display: block;
        font-weight: bold;
        font-size: 14px;
        margin-bottom: 6px;
        color: #444;
    }

    input[type="email"], input[type="password"] {
        width: 100%;
        padding: 14px;
        margin-bottom: 20px;
        border: 1px solid #ddd;
        border-radius: 8px;
        background-color: #f7f7f7;
        font-size: 14px;
        color: #333;
    }

    input[type="email"]:focus, input[type="password"]:focus {
        border-color: #0288d1;
        background-color: #e1f5fe; /* Light blue background on focus */
        outline: none;
    }

    input[type="submit"] {
        background-color: #0288d1; /* Blue button */
        color: #fff;
        padding: 14px;
        font-size: 16px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        width: 100%;
        font-weight: bold;
        transition: background 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #01579b; /* Darker blue on hover */
    }

    a {
        display: block;
        margin-top: 20px;
        color: #0288d1;
        font-weight: bold;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    h1.error-message {
        color: red;
        font-size: 16px;
        font-weight: bold;
        margin-top: -15px; /* Adjust position of error message */
    }

</style>
</head>
<body>

<form action="login" method="post">
    <h1>Login Page</h1>
    
    <label for="uemail">Email :</label>
    <input type="email" name="uemail" id="uemail" required><br>
    
    <label for="upassword">Password :</label>
    <input type="password" name="upassword" id="upassword" required><br>

    <% if(request.getAttribute("status") != null) { %>
        <h1 class="error-message">Invalid User email or password</h1>
    <% } %>

    <input type="submit" value="Login">
    <a href="reg.html">SignUp</a>
</form>

</body>
</html>
