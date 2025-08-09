Of course. Here are all the local URLs for your application's endpoints, perfect for use in your browser or a tool like Postman.

Since your application is running on port 8081, all URLs will start with http://localhost:8081.

## Health Check URL
Use this simple GET request to verify that your backend is running.

GET http://localhost:8081/health

## JSP Page URLs (for Browser)
These are the URLs you will navigate to in your web browser to interact with the JSP views.

List All Users: http://localhost:8081/jsp/users

Show Create User Form: http://localhost:8081/jsp/users/create

Show Edit User Form: http://localhost:8081/jsp/users/edit/{id} (e.g., http://localhost:8081/jsp/users/edit/1)

Delete a User: http://localhost:8081/jsp/users/delete/{id} (e.g., http://localhost:8081/jsp/users/delete/1)

## REST API URLs (for Postman)
These are the backend API endpoints. You will use these in Postman to test your API directly, typically sending and receiving JSON data.

Get All Users:

GET http://localhost:8081/api/users

Get a Single User by ID:

GET http://localhost:8081/api/users/{id} (e.g., http://localhost:8081/api/users/1)

Create a New User:

POST http://localhost:8081/api/users

Body: In Postman, go to the "Body" tab, select "raw", choose "JSON", and provide a user object:

JSON

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "securepassword123"
}
Update an Existing User:

PUT http://localhost:8081/api/users/{id} (e.g., http://localhost:8081/api/users/1)

Body: Provide the updated user data in the same JSON format as the create request.

Delete a User:

DELETE http://localhost:8081/api/users/{id} (e.g., http://localhost:8081/api/users/1)

<img width="992" height="523" alt="image" src="https://github.com/user-attachments/assets/831cc4f9-1fa7-467d-a715-8bbe27140fe6" />

User Overview

<img width="1918" height="910" alt="image" src="https://github.com/user-attachments/assets/b8632081-e528-45b1-bda4-53eec4a64de4" />

Create New User

<img width="1909" height="927" alt="image" src="https://github.com/user-attachments/assets/4c7e4596-a31a-4a7e-b159-cb4c721fec93" />

Edit User

<img width="1903" height="904" alt="image" src="https://github.com/user-attachments/assets/f30f83c4-7722-4ed0-83eb-7fb36e2b3240" />

Delete

<img width="1914" height="837" alt="image" src="https://github.com/user-attachments/assets/8cb67f36-b693-4958-836f-4d4e289df2e2" />




