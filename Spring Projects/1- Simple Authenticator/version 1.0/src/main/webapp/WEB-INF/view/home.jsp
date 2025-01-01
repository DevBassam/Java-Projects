<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Members Data</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home-styles.css">
</head>
<body>
    <div class="table-container">
        <div class="header">
            <h2>User Information</h2>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Number</th>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${membersData}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${entry.key}</td>
                        <td>${entry.value[0]}</td>
                        <td>${entry.value[1]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>