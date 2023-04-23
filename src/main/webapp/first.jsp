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
    <title>first jsp</title>
  </head>
    <body>
    <%

      response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
      response.setHeader("Pragma" , "no-cache");
      response.setHeader("expires" , "0");
      if (request.getSession().getAttribute("userInfo") == null) {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
      }
    %>
    Hello
    <br>
    ${wlcMess}<br>

    <form method="get" action="showData">
      please enter uoyr username again : <input type="text" name="uname"><br>
      <input type="submit" value="fetch"><br>
    </form>

    <a href="logOut">log out</a>

    </body>
</html>
