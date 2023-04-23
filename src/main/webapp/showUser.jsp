<%--
  Created by IntelliJ IDEA.
  User: amr.fathi
  Date: 9/24/2022
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>shpw user</title>
</head>
<body>
<%
    String userLoginedInfo =  request.getAttribute("userLoginedInfo").toString();
    out.print(userLoginedInfo);
%>
</body>
</html>
