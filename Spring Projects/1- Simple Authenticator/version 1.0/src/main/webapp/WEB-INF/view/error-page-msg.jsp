<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error Message</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/error-msg-styles.css">
</head>
<body>
    <div class="message-container">
        <div class="error-message">
            ${errorMsg}
        </div>

        <a href="${pageContext.request.contextPath}/login" class="login-link">
            <div class="login-button">Login</div>
        </a>
    </div>
</body>
</html>