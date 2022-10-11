<%@ page import="java.util.List" %>
<%@ page import="com.dlct.utils.MybatisUtils" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.dlct.Mapper.BookMapper" %>
<%@ page import="com.dlct.pojo.Book" %><%--
  Created by IntelliJ IDEA.
  User: 18109
  Date: 2022/9/27
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>图书管理系统</title>
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <%
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    BookMapper mapper = sqlSession.getMapper(BookMapper.class);
    List<Book> books = mapper.queryAllBook();
    request.setAttribute("list", books);
  %>
</head>
<body>

<div class="right_col" role="main" style="height:800px">
  <div class="row">
    <div class="col-md-9">
      <!-- <h4>答辩资格名单</h4> -->
      <ul class="list-inline">
        <li>图书管理系统</li>
        <li>/</li>
        <li>图书名单</li>
      </ul>
      <table class="table ">
        <thead>
        <tr>
          <th>书号</th>
          <th>书名</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="book">
          <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
          </tr>

        </c:forEach>
        </tbody>

      </table>
    </div>
  </div>
</div>
</body>
</html>