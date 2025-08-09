<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create User - CartCraft</title>
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
        <h2>Create New User</h2>
        <form action="/jsp/users" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required/>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required/>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required/>

            <div class="button-container">
                <button type="submit" class="btn btn-success">Save User</button>
                <a href="/jsp/users" class="link-secondary">Cancel</a>
            </div>
        </form>
    </div>
</div>

<div class="footer">
    <p>&copy; 2025 Shubham Vaish. All Rights Reserved.</p>
</div>

</body>
</html>