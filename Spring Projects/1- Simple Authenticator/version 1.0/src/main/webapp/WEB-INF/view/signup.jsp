<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/signup-styles.css">
</head>
<body>
    <div class="signup-container">
        <div class="signup-header">
            <h1>Create Account</h1>
        </div>
        <form:form id="signupForm" modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/user/signup">
            <div class="form-row">
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <form:input path="firstName" id="firstName" class="form-control"/>
                    <form:errors path="firstName" class="error-message"/>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <form:input path="lastName" id="lastName" class="form-control"/>
                    <form:errors path="lastName" class="error-message"/>
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email Address</label>
                <form:input path="email" id="email" type="email" class="form-control"/>
                <form:errors path="email" class="error-message"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <form:password path="password" id="password" class="form-control"/>
                <form:errors path="password" class="error-message"/>
            </div>
            <button type="submit" class="signup-button">Sign Up</button>
        </form:form>
         <a href="${pageContext.request.contextPath}/login" class="login-link">Already have an account? Login here</a>
    </div>
</body>
</html>