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

        <form action="products" method="post">
            <tr>
                <td>${product.name}<input hidden=true name="name" value="${product.name}"></td>
                <td>${product.description}<input hidden=true name="description" value="${product.description}"></td>
                <td>${product.price}<input hidden=true name="price" value="${product.price}"></td>
                <td>
                    <button type="submit">ADD TO BASKET</button>
                </td>
            </tr>
        </form>

        </c:forEach>
</center>
</table><br><br>
<a href="basket">PAYMENT</a><br><br>
<a href="claim">Claim to Product</a><br><br>
</body>
</html>
