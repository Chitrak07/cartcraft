<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<h2>Create User</h2>

<form action="/jsp/users/create" method="post">
    <label>Name:</label><br/>
    <input type="text" name="name" required/><br/><br/>

    <label>Email:</label><br/>
    <input type="email" name="email" required/><br/><br/>

    <label>Password:</label><br/>
    <input type="password" name="password" required/><br/><br/>

    <button type="submit">Save</button>
</form>

<a href="/jsp/users">Back to List</a>

</body>
</html>
