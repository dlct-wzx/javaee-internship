<%--
  Created by IntelliJ IDEA.
  User: 18109
  Date: 2022/9/27
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <%

        String account = "";
        String password = "";
        String error = (String) session.getAttribute("error_my");
        if (session.getAttribute("rem") != null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("account".equals(cookie.getName())) {
                        account = (String) cookie.getValue();
                    }
                    if ("password".equals(cookie.getName())) {
                        password = (String) cookie.getValue();
                    }
                }
            }
%>
            <script>
                var ju = true;
            </script>
<%
        }
        if(error != null){
    %>
        <script type="text/javascript">
            var ju = false;
            alert("<%=error%>错误");
        </script>
    <%
        }
    %>
</head>
<body>
    <form action="${pageContext.request.contextPath}/book/allBook" method="post">
        账号：<input type="text" name="account" value="<%=account%>"> <br>
        密码：<input type="password" name="password" value="<%=password%>"> <br>
        自动登录：<input type="checkbox" name="remember" value="true"> <br>
        <input type="submit" value="提交">
    </form>
    <script>
        if (ju === true){
            document.forms[0].submit();
        }
    </script>
</body>
</html>
