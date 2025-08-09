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
