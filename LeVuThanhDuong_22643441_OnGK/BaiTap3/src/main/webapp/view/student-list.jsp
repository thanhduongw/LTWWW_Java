<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <title>Danh sách sinh viên</title>
  <style>
    body {
      font-family: "Segoe UI", Tahoma, sans-serif;
      background-color: #f5f7fa;
      margin: 0;
      padding: 40px;
    }

    h1 {
      text-align: center;
      color: #2c3e50;
    }

    .search-container {
      text-align: center;
      margin-bottom: 25px;
      display: flex;
      justify-content: center;
      gap: 15px;
      align-items: center;
      flex-wrap: wrap;
    }

    input[name="name"] {
      padding: 8px 14px;
      width: 240px;
      border: 1px solid #ccc;
      border-radius: 6px;
      outline: none;
      transition: border-color 0.3s;
    }

    input[name="name"]:focus {
      border-color: #3498db;
    }

    select[name="clazzId"] {
      padding: 8px 14px;
      border: 1px solid #ccc;
      border-radius: 6px;
      outline: none;
      transition: border-color 0.3s;
    }

    select[name="clazzId"]:focus {
      border-color: #3498db;
    }

    button {
      padding: 8px 14px;
      border: none;
      background-color: #3498db;
      color: white;
      border-radius: 6px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    button:hover {
      background-color: #2980b9;
    }

    .add-btn {
      display: block;
      text-align: center;
      margin: 20px auto;
      padding: 10px 20px;
      background-color: #27ae60;
      color: white;
      text-decoration: none;
      border-radius: 6px;
      width: fit-content;
      transition: background-color 0.3s;
    }

    .add-btn:hover {
      background-color: #219653;
      text-decoration: none;
    }

    table {
      width: 90%;
      margin: 0 auto;
      border-collapse: collapse;
      background-color: white;
      box-shadow: 0 2px 10px rgba(0,0,0,0.1);
      border-radius: 8px;
      overflow: hidden;
    }

    th, td {
      padding: 12px 15px;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #3498db;
      color: white;
    }

    tr:hover {
      background-color: #f1f9ff;
    }

    a {
      color: #2980b9;
      text-decoration: none;
      margin-right: 8px;
    }

    a:hover {
      text-decoration: underline;
    }

    form[method="post"] {
      display: inline;
    }

    .delete-btn {
      background-color: #e74c3c;
      border: none;
      color: white;
      padding: 6px 10px;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .delete-btn:hover {
      background-color: #c0392b;
    }
  </style>
</head>
<body>

<h1>Danh sách sinh viên</h1>
<div class="nav-container">
  <a href="student" class="nav-btn student">📚 Quản lý Sinh viên</a>
  <a href="clazz" class="nav-btn">🏫 Quản lý Lớp học</a>
</div>

<a href="student?action=add" class="add-btn">➕ Thêm sinh viên</a>

<div class="search-container">
  <form method="GET" action="student" style="display: flex; gap: 10px; align-items: center;">
    <select name="clazzId">
      <option value="ALL">Tất cả lớp</option>
      <c:forEach items="${clazzList}" var="clazz">
        <option value="${clazz.id}"
          ${param.clazzId == clazz.id ? 'selected' : ''}>
            ${clazz.name}
        </option>
      </c:forEach>
    </select>
    <button type="submit">Lọc theo lớp</button>
  </form>
  <form method="GET" action="student" style="display: flex; gap: 10px; align-items: center;">
    <input type="hidden" name="clazzId" value="${param.clazzId}">
    <input name="name" placeholder="Nhập MSSV hoặc tên sinh viên..." value="${param.name}">
    <button type="submit">Tìm kiếm</button>
  </form>

</div>

<table>
  <tr>
    <th>MSSV</th>
    <th>Họ tên</th>
    <th>Ngày sinh</th>
    <th>Điểm</th>
    <th>Lớp</th>
    <th>Hành động</th>
  </tr>
  <c:forEach items="${studentList}" var="student">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.dob}</td>
      <td>${student.score}</td>
      <td>${student.clazz.name}</td>
      <td>
        <a href="student?action=edit&id=${student.id}">Sửa</a>
        <a href="student?action=detail&id=${student.id}">Chi tiết</a>
        <form action="student" method="post">
          <input type="hidden" name="action" value="delete">
          <input type="hidden" name="id" value="${student.id}">
          <button type="submit" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa lớp ${student.id
          }?')">Xóa</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>

<c:if test="${empty studentList}">
  <p style="text-align: center; color: #7f8c8d; margin-top: 20px;">Không có sinh viên nào.</p>
</c:if>

</body>
</html>