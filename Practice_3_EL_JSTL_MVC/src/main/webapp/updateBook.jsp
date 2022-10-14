<%@ page import="com.dlct.dao.BookDao" %>
<%@ page import="com.dlct.service.BookService" %>
<%@ page import="com.dlct.pojo.Book" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 18109
  Date: 2022/10/13
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>修改书籍</title>
  <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  BookDao bookDao = new BookService();
  Book book = null;
  try {
    book = bookDao.queryBookById(id);
  } catch (SQLException e) {
    throw new RuntimeException(e);
  }
  request.setAttribute("book", book);
%>

<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          <small>修改书籍</small>
        </h1>
      </div>
    </div>
  </div>

  <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
    <div class="form-group">
      <label>书籍编号</label>
      <input type="text" class="form-control" name="bookID" value="${book.bookID}" readonly>
    </div>
    <div class="form-group">
      <label>书籍名称</label>
      <input type="text" class="form-control" name="bookName" value="${book.bookName}" required>
    </div>
    <div class="form-group">
      <label>书籍数量</label>
      <input type="text" class="form-control" name="bookCounts" value="${book.bookCounts}" required>
    </div>
    <div class="form-group">
      <label>书籍描述</label>
      <input type="text" class="form-control" name="detail" value="${book.detail}" required>
    </div>
    <button type="submit" class="btn btn-default">确认修改</button>
  </form>

</div>

</body>
</html>
