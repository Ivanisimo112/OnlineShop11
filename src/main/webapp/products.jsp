<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All products</title>
</head>
<body>
<center>
    <h2>Products</h2>
    <table border="1">
        <c:forEach var="product" items="${allProducts}">
        <tr>
            <td>${product.name}</td>
            <td>${product.discriptional}</td>
            <td>${product.price}</td>
            <td><button type="submit">ADD TO BASKET</button></td>
        </tr>
        </c:forEach>
</center>
</table><br><br>
<a href="addProduct">SHOPPING BASKET</a><br><br>
</body>
</html>
