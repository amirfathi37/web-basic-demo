<%--
  Created by IntelliJ IDEA.
  User: amr.fathi
  Date: 9/21/2022
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
  <form action="login" method="post">
    username : <input type="text" name="username"/><br>
    password : <input type="password" name="password"/><br>
    <input type="submit" value="login"><br>
    ${loginMessage}

    </form>
  </body>
</html>
