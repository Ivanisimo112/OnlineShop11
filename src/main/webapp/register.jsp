<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<center>
    <h3>${error}</h3>
    <form action="register" method="post">
        Email <input name="email" type="email" value=${email}><br><br><br>
        Password <input name ="password" type="password"><br><br>
        Repeat password <input name ="repeatPassword" type="password"><br><br>
        <button type="submit"> Register</button>
    </form>
</center>
</body>
</html>
