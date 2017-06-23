<%--
  Created by IntelliJ IDEA.
  User: 21cmPC
  Date: 02.04.2017
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
