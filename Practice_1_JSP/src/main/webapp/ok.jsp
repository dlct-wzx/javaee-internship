<%--
  Created by IntelliJ IDEA.
  User: 18109
  Date: 2022/9/27
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.lang.*" language="java" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String sex = request.getParameter("sex");
    String hobbies = Arrays. toString(request.getParameterValues("hobby"));

    if (age < 16){
%>
    <h3>ERROR:你的年龄是<%=age%>,小于16</h3>
<%
    }else {
%>
    <h3>你的姓名为：<%=name%></h3>
    <h3>你的年龄为：<%=age%></h3>
    <h3>你的性别为：<%=sex%></h3>
    <h3>你的爱好为：<%=hobbies%></h3>

<%
    }
%>
</body>
</html>
