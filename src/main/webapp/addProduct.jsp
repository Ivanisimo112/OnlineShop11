<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<center>
    <h3>${error2}</h3>
    <form action="addProduct" method="post">
    Name <input name ="name" type="text" value= ${name}><br><br>
    Discriptional <input name ="discriptional" type="text" value= ${discriptional}><br><br>
    Price <input name = "price" type="text" value= ${price}><br><br>
    Product quantity <input name = "productQuantity" type="text"value= ${productQuantity}><br><br>
    <button type="submit"> Create</button>
</form>
</center>
</body>
</html>
