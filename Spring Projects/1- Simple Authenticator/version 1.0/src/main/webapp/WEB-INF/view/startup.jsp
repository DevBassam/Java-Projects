<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navigation</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/startup-styles.css">
</head>
<body>
    <div class="button-container">
        <a href="${pageContext.request.contextPath}/login"><button class="nav-button login-button">Login</button></a>
        <a href="${pageContext.request.contextPath}/signup"><button class="nav-button signup-button">Sign Up</button></a>
    </div>
</body>
</html>


