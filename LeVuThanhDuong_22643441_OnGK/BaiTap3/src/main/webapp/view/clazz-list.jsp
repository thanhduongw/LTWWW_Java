<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách lớp học</title>
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
            width: 80%;
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
            text-align: center;
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

<h1>Danh sách lớp học</h1>
<div class="nav-container">
    <a href="student" class="nav-btn student">📚 Quản lý Sinh viên</a>
    <a href="clazz" class="nav-btn" onselect="true">🏫 Quản lý Lớp học</a>
</div>
<a href="clazz?action=add" class="add-btn">➕ Thêm lớp học</a>

<table>
    <tr>
        <th>Mã lớp</th>
        <th>Tên lớp</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${clazzList}" var="clazz">
        <tr>
            <td>${clazz.id}</td>
            <td>${clazz.name}</td>
            <td>
                <a href="clazz?action=edit&id=${clazz.id}">Sửa</a>
                <form action="clazz" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${clazz.id}">
                    <button type="submit" class="delete-btn"
                            onclick="return confirm('Bạn có chắc chắn muốn xóa lớp ${clazz.name}?')">
                        Xóa
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${empty clazzList}">
    <p style="text-align: center; color: #7f8c8d; margin-top: 20px;">Không có lớp học nào.</p>
</c:if>

</body>
</html>