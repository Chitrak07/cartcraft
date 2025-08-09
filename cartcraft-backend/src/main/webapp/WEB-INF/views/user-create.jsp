<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create User - CartCraft</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="header">
    <h1>🛒 CartCraft Admin</h1>
</div>

<div class="container">
    <div class="form-container">
        <h2>Create New User</h2>
        <form action="/jsp/users" method="post">
            <label>Name:</label>
            <input type="text" name="name" required/>

            <label>Email:</label>
            <input type="email" name="email" required/>

            <label>Password:</label>
            <input type="password" name="password" required/>

            <div class="button-container">
                <button type="submit" class="save-btn">Save User</button>
                <a href="/jsp/users">Back to List</a>
            </div>
        </form>
    </div>
</div>

<div class="footer">
    <p>&copy; 2025 Shubham Vaish. All Rights Reserved.</p>
</div>

</body>
</html>