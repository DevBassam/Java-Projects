<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Requirements</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/signup-instruction-styles.css">
</head>
<body>
    <div class="requirements-container">
        <div class="requirement-item">
            <span class="requirement-label">First Name:</span>
            <span class="requirement-text">Please enter a single word containing alphabetical characters only. Special characters and numbers are not permitted.</span>
        </div>

        <div class="requirement-item">
            <span class="requirement-label">Last Name:</span>
            <span class="requirement-text">Please enter a single word containing alphabetical characters only. Special characters and numbers are not permitted.</span>
        </div>

        <div class="requirement-item">
            <span class="requirement-label">Email Address:</span>
            <span class="requirement-text">A valid Gmail account is required (example@gmail.com).</span>
        </div>

        <div class="requirement-item">
            <span class="requirement-label">Password Requirements:</span>
            <span class="requirement-text">Your password must meet the following criteria:
                <br>• Minimum length: 8 characters
                <br>• Maximum length: 20 characters
                <br>• Must contain at least:
                <br>&nbsp;&nbsp;&nbsp;- One uppercase letter (A-Z)
                <br>&nbsp;&nbsp;&nbsp;- One lowercase letter (a-z)
                <br>&nbsp;&nbsp;&nbsp;- One number (0-9)
                <br>&nbsp;&nbsp;&nbsp;- One special character (!@#$%^&*)</span>
        </div>

        <a href="${pageContext.request.contextPath}/signup" class="signup-link">
            <div class="signup-button">Sign Up Page</div>
        </a>
    </div>
</body>
</html>