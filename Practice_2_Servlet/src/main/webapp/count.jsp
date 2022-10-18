<%--
  Created by IntelliJ IDEA.
  User: 18109
  Date: 2022/10/4
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>生命周期事件</title>
</head>
<body>
    <p>当前应用启动时间：<%=application.getAttribute("StartDate") %></p>
    <p>当前在线人数：<%=application.getAttribute("sessionCnt") %></p>
    <p>处理请求数：<%=application.getAttribute("reqcnt") %></p>
</body>
</html>
