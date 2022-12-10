<%--
  Created by IntelliJ IDEA.
  User: 常兆海
  Date: 2022/12/10
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--//${pageContext.request.contextPath}代表根目录--%>
<form action="${pageContext.request.contextPath}/a/insert" method="post">
    <input type="text"name="name">
    <input type="password"  name="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
