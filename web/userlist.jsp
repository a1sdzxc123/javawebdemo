<%--
  Created by IntelliJ IDEA.
  User: my computer
  Date: 2019/11/19
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>所有用户页面</title>
</head>

<body>
<h1>${xiaoxi}</h1>
<table  width="600" border="1" cellpadding="0" >
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>密码</th>
        <th>家乡</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <c:forEach var="U" items="${userAll}"  >
        <form action="UpdateUser" method="post">
            <tr>
                <td><input type="text" value="${U.id}" name="id" ></td>
                <td><input type="text" value="${U.name}" name="name"></td>
                <td><input type="text" value="${U.sex}" name="sex"></td>
                <td><input type="text" value="${U.pwd}" name="pwd"></td>
                <td><input type="text" value="${U.home}" name="home"></td>
                <td><input type="text" value="${U.info}" name="info"></td>
                <td><a href="DeleteUser?id=${U.id}">删除</a>  <input type="submit" value="更新"/></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>

