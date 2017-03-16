<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 21cmPC
  Date: 15.03.2017
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FTP_SERVER:List_files</title>
</head>
<body>
<p align="center">FTP_SERVER: list files</p>
<%
    List<String> files = (List<String>) request.getAttribute("list");
%>

<form method="get" action="precall">
    <% for (String item : files) { %>

    <input name="file" type="radio" value="<%out.print(item.toString());%>"> <% out.print(item); %> <br>

    <% } %>
    <br><br><br>
    <p><input name="action" type="radio" value="delete">Delete</p>
    <p><input name="action" type="radio" value="download"> Download</p>
    <p><input name="action" type="radio" value="upload"> Add file</p>
    <br>
    <input type="submit" name="Update">
</form>

</body>
</html>
