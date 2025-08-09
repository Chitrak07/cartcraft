<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>All Users</h2>

<a href="/jsp/users/create">Create New User</a>
<br/><br/>

<table border="1" cellpadding="5">
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
                <a href="/jsp/users/delete/${user.id}"
                   onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
