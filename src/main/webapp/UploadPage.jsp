
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%request.setCharacterEncoding("UTF-8");%>
<p align="center">Choose file to upload</p><br>

<form action="<%=response.encodeURL("upload")%>"  method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="Upload"/>
    <br><br><br><br><br>
    <p align="right"><font color="black">
        <c:out value="${sessionScope.userName}" default="guest"/>
    </font></p>
</form>
</body>
</html>
