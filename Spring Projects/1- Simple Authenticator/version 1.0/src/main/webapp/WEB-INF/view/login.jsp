<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login-styles.css">
</head>
<body>
    <div class="login-container">
        <div class="login-header">
            <h1>Login</h1>
        </div>
        <form method="POST" action="${pageContext.request.contextPath}/user/login">
            <div class="form-group">
                <label for="email">E-mail</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <input type="submit" class="login-button" value="Log In"/>
        </form>
         <a href="${pageContext.request.contextPath}/signup" class="signup-link">Don't have an account? Sign up</a>
    </div>
</body>
</html>