<%--
  Created by IntelliJ IDEA.
  User: 18109
  Date: 2022/9/27
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>管理界面</title>
</head>
<body>
<%
  //未登录，跳转到登录界面
  if (session.getAttribute("login") == null){
    response.sendRedirect("login.jsp");
  }
%>
<h1>
  欢迎进入管理界面
</h1>
</body>
</html>
