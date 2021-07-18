<%@ page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Payment</title>
</head>
<body>
<center>
    <h2>YOUR BASKET</h2>
    <table border="1">
        <c:forEach var="product" items="${basket}">
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </table>
    Email <input name="email" type="email"/><br><br>
    Card code<input name="card" type="number"><br><br>
    <br><br>
    <form action="payment" method="post">
        <button type="submit">PAY</button>
    </form>
</center>
</body>
</html>
