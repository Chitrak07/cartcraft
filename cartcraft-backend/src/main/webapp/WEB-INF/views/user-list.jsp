<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management - CartCraft</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="header">
    <h1>🛒 CartCraft Admin</h1>
    <a href="/health" target="_blank">Health Check</a>
</div>

<div class="container">
    <div class="list-container">
        <h2>All Users</h2>
        <a href="/jsp/users/create" class="create-link">Create New User</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Created At</th>
                <th>Updated At</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.createdAt}</td>
                    <td>${user.updatedAt}</td>
                    <td>
                        <a href="/jsp/users/edit/${user.id}">Edit</a> |
                        <a href="/jsp/users/delete/${user.id}" class="delete"
                           onclick="return confirm('Are you sure?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<div class="footer">
    <p>&copy; 2025 Shubham Vaish. All Rights Reserved.</p>
</div>

</body>
</html>