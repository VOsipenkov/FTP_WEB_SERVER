
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1 align="Center">Welcome to FTP Server</H1>
<br><br><br>
<form method="get" action= "<%= response.encodeURL("login")%>">

    <label>enter your name:</label><br>
    <input type="text" name="name"><br>
    <input type="submit">
</form>
</body>
</html>
