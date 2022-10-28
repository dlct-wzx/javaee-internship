<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        .app{
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
        }
    </style>
    <%
        if(session.getAttribute("errorr") != null){
    %>
        <script>
            alert('<%=session.getAttribute("errorr")%>')
        </script>
    <%
        }
    %>
</head>
<body>
<div class="app">
    <form action="${pageContext.request.contextPath}/book/allBook" method="post">
        账号：<input type="text" name="name"> <br>
        密码：<input type="password" name="pwd"> <br>
        <input type="submit" value="提交">
    </form>

</div>
</body>
</html>
