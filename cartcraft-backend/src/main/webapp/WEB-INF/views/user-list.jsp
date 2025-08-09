<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management - CartCraft</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/modern-style.css">
</head>
<body>

<div class="header">
    <div class="logo-container">
        <img src="${pageContext.request.contextPath}/images/logo.png" alt="CartCraft Logo">
        <h1>CartCraft Admin</h1>
    </div>
</div>

<div class="container">
    <div class="card">
        <h2>User Overview</h2>
        <div class="toolbar">
            <form action="/jsp/users" method="get" class="search-form">
                <input type="text" name="keyword" value="${keyword}" placeholder="Search by name or email...">
                <button type="submit" class="btn btn-primary">Search</button>
                <a href="/jsp/users" class="clear-search">Clear</a>
            </form>
            <a href="/jsp/users/create" class="create-link">Add New User</a>
        </div>

        <table class="modern-table">
            <thead>
                <tr>
                    <th>
                        <a href="/jsp/users?sortField=id&sortDir=${sortField == 'id' ? reverseSortDir : 'asc'}&keyword=${keyword}">
                            ID <c:if test="${sortField == 'id'}"><span class="sort-arrow">${sortDir == 'asc' ? '▲' : '▼'}</span></c:if>
                        </a>
                    </th>
                    <th>
                        <a href="/jsp/users?sortField=name&sortDir=${sortField == 'name' ? reverseSortDir : 'asc'}&keyword=${keyword}">
                            Name <c:if test="${sortField == 'name'}"><span class="sort-arrow">${sortDir == 'asc' ? '▲' : '▼'}</span></c:if>
                        </a>
                    </th>
                    <th>
                        <a href="/jsp/users?sortField=email&sortDir=${sortField == 'email' ? reverseSortDir : 'asc'}&keyword=${keyword}">
                            Email <c:if test="${sortField == 'email'}"><span class="sort-arrow">${sortDir == 'asc' ? '▲' : '▼'}</span></c:if>
                        </a>
                    </th>
                    <th>
                        <a href="/jsp/users?sortField=createdAt&sortDir=${sortField == 'createdAt' ? reverseSortDir : 'asc'}&keyword=${keyword}">
                            Created At <c:if test="${sortField == 'createdAt'}"><span class="sort-arrow">${sortDir == 'asc' ? '▲' : '▼'}</span></c:if>
                        </a>
                    </th>
                     <th>
                        <a href="/jsp/users?sortField=updatedAt&sortDir=${sortField == 'updatedAt' ? reverseSortDir : 'asc'}&keyword=${keyword}">
                            Updated At <c:if test="${sortField == 'updatedAt'}"><span class="sort-arrow">${sortDir == 'asc' ? '▲' : '▼'}</span></c:if>
                        </a>
                    </th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.createdAt}</td>
                        <td>${user.updatedAt}</td>
                        <td>
                            <a href="/jsp/users/edit/${user.id}" class="action-link edit">Edit</a> |
                            <a href="/jsp/users/delete/${user.id}" class="action-link delete"
                               onclick="return confirm('Are you sure?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="footer">
    <p>&copy; 2025 Shubham Vaish. All Rights Reserved.</p>
</div>

</body>
</html>
<style>
    .toolbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 25px;
    }
    .search-form {
        display: flex;
        gap: 10px;
    }
    .search-form .btn {
        padding-top: 10px;
        padding-bottom: 10px;
        margin-bottom: 0; /* Ensures vertical alignment */
    }
    .search-form input {
        margin-bottom: 0;
    }
    .clear-search {
        display: flex;
        align-items: center;
        text-decoration: none;
        color: var(--danger-red);
        font-weight: 600;
    }
</style>