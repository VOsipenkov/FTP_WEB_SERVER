<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FTP_SERVER:List_files</title>
</head>
<body>
<p align="center">FTP_SERVER: list files</p>

<%@ taglib prefix="lists" uri="ElFunctions" %>
<%@page pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<form method="get" action="<%= response.encodeURL("precall")%>">

    ${lists:listFiles(requestScope.list)}

    <br><br><br>
    <p><input name="action" type="radio" value="delete">Delete</p>
    <p><input name="action" type="radio" value="download"> Download</p>
    <p><input name="action" type="radio" value="upload"> Add file</p>
    <br>
    <input type="submit" name="Update">

    <br><br><br><br><br>
    <p align="right"><font color="black">
        ${lists:userName(sessionScope.userName)}
    </font></p>
</form>

</body>
</html>
