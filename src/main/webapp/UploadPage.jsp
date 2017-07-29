
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@page pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<p align="center">Choose file to upload</p><br>

<form action="<%=response.encodeURL("upload")%>"  method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="Upload"/>
    <br><br><br><br><br>
    <p align="right"><font color="black">
        <%@ taglib prefix="lists" uri="ElFunctions" %>
        ${lists:userName(sessionScope.userName)}
    </font></p>
</form>
</body>
</html>
