<%--
  Created by IntelliJ IDEA.
  User: DUONG
  Date: 23/10/2025
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>List Student</title>
</head>
<body>
  <table border="1", width="90%">
    <tr>
      <th>Mssv</th>
      <th>Ho Ten</th>
      <th>Ngay Sinh</th>
      <th>Diem</th>
      <th>Lop</th>
      <th>Action</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
      <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.dob}</td>
        <td>${student.score}</td>
        <td>${student.clazz.getName()}</td>
        <td>
          <a href="">Sửa</a>
          <form action="student" method="post" style="display:inline;">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="id" value="${student.id}">
            <button type="submit">Xóa</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
