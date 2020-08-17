<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<center>
    <h2>Users</h2>
    <table border="1">
        <td>Email</td>
        <td>Password</td>
        <c:forEach var="user" items="${allUsers}">
            <tr>
                <td>${user.email}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <a href="register">Register New User</a><br><br>
    <a href="products">Products</a>
    <br><br><br><br><br>
    <form action="users" method="post">
        Delete User <input name="delete" type="number"><br><br>
        <button type="submit">Delete</button>
</form>
</center>
</body>
</html>
