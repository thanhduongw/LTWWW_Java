<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Thông tin lớp học</title>
  <style>
    body {
      font-family: "Segoe UI", sans-serif;
      background-color: #f7f9fc;
      padding: 40px;
    }
    .form-container {
      width: 400px;
      margin: 0 auto;
      background: white;
      padding: 25px;
      border-radius: 10px;
      box-shadow: 0 3px 12px rgba(0,0,0,0.1);
    }
    h2 {
      text-align: center;
      color: #2c3e50;
    }
    label {
      display: block;
      margin-top: 12px;
      font-weight: bold;
    }
    input {
      width: 100%;
      padding: 8px;
      border-radius: 6px;
      border: 1px solid #ccc;
      margin-top: 5px;
      box-sizing: border-box;
    }
    button {
      margin-top: 20px;
      width: 100%;
      padding: 10px;
      border: none;
      background-color: #3498db;
      color: white;
      border-radius: 6px;
      cursor: pointer;
    }
    button:hover {
      background-color: #2980b9;
    }
    a {
      display: block;
      text-align: center;
      margin-top: 10px;
      color: #555;
      text-decoration: none;
    }
    a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

<div class="form-container">
  <h2>${clazz == null ? "Thêm lớp học" : "Cập nhật lớp học"}</h2>

  <form action="clazz" method="post">
    <input type="hidden" name="action" value="${clazz == null ? 'add' : 'update'}">

    <label>Mã lớp:</label>
    <input type="text" name="malop" value="${clazz.id}"
    ${clazz != null ? "readonly" : ""}
           placeholder="Nhập mã lớp" required>

    <label>Tên lớp:</label>
    <input type="text" name="tenlop" value="${clazz.name}"
           placeholder="Nhập tên lớp" required>

    <button type="submit">${clazz == null ? "Thêm mới" : "Cập nhật"}</button>
  </form>

  <a href="clazz">← Quay lại danh sách</a>
</div>

</body>
</html>