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
    <title>Title</title>
</head>
<body>
<%

    String error = null;
    //获取账号密码
    String account = (String)request.getParameter("account");
    String password = (String)request.getParameter("password");
    //是否记住账号密码
    if (request.getParameterValues("remember") != null){
        session.setAttribute("rem", true);
        //设置cookie
        Cookie account1 = new Cookie("account", account);
        Cookie password1 = new Cookie("password", password);
        response.addCookie(account1);
        response.addCookie(password1);
    }else {
        session.removeAttribute("rem");
    }
    //检查账号密码的错误
    if (!"123456".equals(account) && !"123456".equals(password) ){
        error = "账号和密码";
    }
    else if (!"123456".equals(account)){
        error = "账号";
    } else if(!"123456".equals(password)){
        error = "密码";
    }
    //有错误，在session中设置信息并跳转
    if (error != null){
        session.setAttribute("errorr", error);
        response.sendRedirect("login.jsp");
    } else {
        session.removeAttribute("errorr");
        session.setAttribute("login", true);
        response.sendRedirect("admin.jsp");
    }
    //无错误，设置错误并跳转

%>

</body>
</html>
