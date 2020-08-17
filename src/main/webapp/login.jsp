<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
    <h3>${error3}</h3>
    <form action="login" method="post">
        Email <input name="email" type="email"/><br><br>
        Password <input name ="password" type="password"><br><br>
        <button type="submit"> Sign in</button>
    </form>
</center>
</body>
</html>
