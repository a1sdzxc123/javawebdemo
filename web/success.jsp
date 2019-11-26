<%--
  Created by IntelliJ IDEA.
  User: my computer
  Date: 2019/11/19
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
    <title>成功页面</title>
</head>
<body>
${xiaoxi} <br>
<a href="FindUserList">查看所有用户</a>
</body>
</html>
