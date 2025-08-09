<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h2>Edit User</h2>

<form action="/jsp/users/edit/${user.id}" method="post">
    <input type="hidden" name="_method" value="put"/>

    <label>Name:</label><br/>
    <input type="text" name="name" value="${user.name}" required/><br/><br/>

    <label>Email:</label><br/>
    <input type="email" name="email" value="${user.email}" required/><br/><br/>

    <label>Password:</label><br/>
    <input type="password" name="password" value="${user.password}" required/><br/><br/>

    <button type="submit">Update</button>
</form>

<a href="/jsp/users">Back to List</a>

</body>
</html>
