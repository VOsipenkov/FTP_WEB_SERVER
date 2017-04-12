<%--
  Created by IntelliJ IDEA.
  User: 21cmPC
  Date: 14.03.2017
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ((cookie.getName().equals("userName")) && (cookie.getValue() != null) && (!cookie.getValue().equals(""))) {
                userName = cookie.getValue();
                request.getSession().setAttribute("userName", userName);
                break;
            }
        }
    }

    if (userName != null) {
        response.sendRedirect(response.encodeRedirectURL("http://localhost:8080/list"));
    } else {
        response.sendRedirect("http://localhost:8080/login.jsp");
    }
%>
</body>
</html>
