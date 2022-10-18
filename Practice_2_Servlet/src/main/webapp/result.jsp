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
    if(session.getAttribute("error_my") == null){
        String name = session.getAttribute("name").toString();
        String age = session.getAttribute("age").toString();
        String sex = session.getAttribute("sex").toString();
        String hobbies = session.getAttribute("hobbies").toString();
%>
        <h3>你的姓名为：<%=name%></h3>
        <h3>你的年龄为：<%=age%></h3>
        <h3>你的性别为：<%=sex%></h3>
        <h3>你的爱好为：<%=hobbies%></h3>
<%
    } else{
%>
        <h3>ERROR:你的年龄小于16</h3>
<%
    }
%>
</body>
</html>
