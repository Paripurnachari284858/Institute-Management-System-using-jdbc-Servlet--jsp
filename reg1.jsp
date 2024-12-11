<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<style>
    body {
        background-color: #e1f5fe; /* Light blue background */
        font-family: 'Roboto', sans-serif;
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
        padding: 35px;
        border-radius: 15px;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1); /* Soft shadow */
        width: 100%;
        max-width: 420px; /* Limit the form width */
        text-align: center;
    }

    h2 {
        font-size: 28px;
        color: #01579b; /* Dark blue heading */
        margin-bottom: 25px;
    }

    label {
        display: block;
        font-weight: bold;
        font-size: 16px;
        margin-bottom: 8px;
        color: #444;
    }

    input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        padding: 14px;
        margin-bottom: 18px;
        border: 1px solid #ddd;
        border-radius: 10px;
        background-color: #f7f7f7;
        font-size: 14px;
        color: #333;
    }

    input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus {
        border-color: #0288d1;
        background-color: #e1f5fe; /* Light blue background on focus */
        outline: none;
    }

    input[type="submit"] {
        background-color: #000000; /* Black button */
        color: #fff;
        padding: 14px;
        font-size: 16px;
        border: none;
        border-radius: 10px;
        cursor: pointer;
        width: 100%;
        font-weight: bold;
        transition: all 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #333333; /* Darker black on hover */
    }

    .error-message {
        color: #d32f2f; /* Red error message */
        font-size: 14px;
        font-weight: bold;
        margin-top: 10px;
    }

    /* Mobile responsiveness */
    @media (max-width: 768px) {
        form {
            padding: 25px;
        }
    }
</style>
</head>
<body>

<form action="reg" method="post">
    <h2>Register Now</h2>
    <label for="name">UserName:</label>
    <input type="text" name="name" id="name" required><br>
    
    <label for="email">Email:</label>
    <input type="email" name="email" id="email" required><br>
    
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" required><br>

    <!-- Error message display -->
    <p class="error-message">
        <% 
            if (request.getAttribute("status") != null) {
                out.println("Email is already in use.");
            }
        %>
    </p>

    <input type="submit" value="Register">
</form>

</body>
</html>

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

