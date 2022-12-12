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
<fieldset>
    <legend>复杂类型数据绑定--数组获取</legend>
<%--//${pageContext.request.contextPath}代表根目录--%>
<form action="${pageContext.request.contextPath}/a/insert" method="post">
    <input type="text"name="name">
    <input type="password"  name="password">
    <input type="text" name="birthday">
    <input type="submit" value="提交">
</form>
</fieldset>
<fieldset>
    <legend>复杂类型数据绑定--数组获取</legend>
    <form action="${pageContext.request.contextPath}/a/comparr" method="post">
        爱好：<input type="checkbox" name="ids" value="chang">
        <input type="checkbox" name="ids" value="tiao">
        <input type="checkbox" name="ids" value="rap">
        <input type="checkbox" name="ids" value="篮球">
        <input type="submit" value="提交">
    </form>
</fieldset>
<fieldset>
    <legend>复杂类型数据绑定--集合获取</legend>
    <form action="${pageContext.request.contextPath}/a/complist" method="post">
        爱好：<input type="checkbox" name="User.ids" value="chang">唱
        <input type="checkbox" name="ids" value="tiao">跳
        <input type="checkbox" name="ids" value="rap">rap
        <input type="checkbox" name="ids" value="篮球">篮球

    </form>
</fieldset>

<fieldset>
    <legend>复杂类型数据绑定--复杂pojo</legend>
    <form action="${pageContext.request.contextPath}/a/comppojo" method="post">
        信息:<input type="text" name="info">
        id: <input type="text" name="id">id

        <fieldset>
            <legend>复杂类型数据绑定--复杂pojo里的简单pojo</legend>
            账户：<br>
            姓名：<input type="text"name="User.name">
            密码：<input type="password"  name="User.password">
            生日：<input type="text" name="User.birthday">
            id：<input type="text" name="User.id">

        </fieldset>

        <input type="submit" value="提交">
    </form>
</fieldset>

<fieldset>
    <legend>复杂类型数据绑定--复杂pojo</legend>
    <form action="${pageContext.request.contextPath}/a/comppojolist" method="post">
        信息:<input type="text" name="info">
        id: <input type="text" name="id">id

        <fieldset>
            <legend>复杂类型数据绑定--复杂pojo里的简单pojo</legend>
            账户：<br>
            姓名：<input type="text"name="User.name">
            密码：<input type="password"  name="User.password">
            生日：<input type="text" name="User.birthday">
            id：<input type="text" name="User.id">

        </fieldset>

        <fieldset>
            <legend>复杂类型数据绑定--复杂pojo里的简单list -pojo</legend>
            账户：<br>
            姓名：<input type="text"name="UserList[0].name">
            密码：<input type="password"  name="UserList[0].password">
            生日：<input type="text" name="UserList[0].birthday">
            id：<input type="text" name="UserList[0].id">
            <legend>复杂类型数据绑定--复杂pojo里的简单list -pojo</legend>
            账户：<br>
            姓名：<input type="text"name="UserList[1].name">
            密码：<input type="password"  name="UserList[1].password">
            生日：<input type="text" name="UserList[1].birthday">
            id：<input type="text" name="UserList[1].id">

        </fieldset>
        <input type="submit" value="提交">
    </form>
</fieldset>


<fieldset>
    <legend>复杂类型数据绑定--复杂pojo</legend>
    <form action="${pageContext.request.contextPath}/a/comppojomap" method="post">
        信息:<input type="text" name="info">
        id: <input type="text" name="id">id



        <fieldset>
            <legend>复杂类型数据绑定--复杂pojo里的简单map -pojo</legend>
            账户：<br>
            姓名：<input type="text"name="usermap['detail'].name">
            密码：<input type="password"  name="usermap['detail'].password">
            生日：<input type="text" name="usermap['detail'].birthday">
            id：<input type="text" name="usermap['detail'].id">
            账户：<br>
            姓名：<input type="text"name="usermap['details'].name">
            密码：<input type="password"  name="usermap['details'].password">
            生日：<input type="text" name="usermap['details'].birthday">
            id：<input type="text" name="usermap['details'].id">

        </fieldset>
        <input type="submit" value="提交">
    </form>
</fieldset>
</body>
</html>
