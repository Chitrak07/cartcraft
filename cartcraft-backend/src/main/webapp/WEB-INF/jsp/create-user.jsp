<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create User</title>
</head>
<body>
    <h2>Create User</h2>
    <form id="createUserForm">
        <label>Name:</label><br/>
        <input type="text" id="name" name="name" required><br/><br/>

        <label>Email:</label><br/>
        <input type="email" id="email" name="email" required><br/><br/>

        <label>Password:</label><br/>
        <input type="password" id="password" name="password" required><br/><br/>

        <button type="submit">Create User</button>
    </form>

    <p id="response"></p>

    <script>
        document.getElementById("createUserForm").addEventListener("submit", async function(e) {
            e.preventDefault();

            const user = {
                name: document.getElementById("name").value,
                email: document.getElementById("email").value,
                password: document.getElementById("password").value
            };

            const response = await fetch("http://localhost:8081/users", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            });

            const resultText = document.getElementById("response");
            if (response.ok) {
                const data = await response.json();
                resultText.innerText = "User created successfully: ID = " + data.id;
            } else {
                resultText.innerText = "Failed to create user. Status: " + response.status;
            }
        });
    </script>
</body>
</html>
