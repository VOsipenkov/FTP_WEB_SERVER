
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
HELLO
<%
    //case for anonimous enter and return to start page
    String userName = (String) request.getSession().getAttribute("userName");

    if (userName == null) {
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
    }
    if (userName != null) {
        response.sendRedirect(response.encodeRedirectURL("./list"));
    } else {
        response.sendRedirect(response.encodeRedirectURL("./login.jsp"));
    }
%>
</body>
</html>
