<%--
  Created by IntelliJ IDEA.
  User: DUONG
  Date: 25/10/2025
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách danh mục</title>
</head>
<body>
</body>
    <h1>Danh sách danh mục</h1>
    <a href="view/danhmuc-form.jsp">Thêm danh mục</a>
    <br>
    <a href="">Danh sách tin tức</a>
    <table border="1">
        <tr>
            <th>maDM</th>
            <th>tenDanhMuc</th>
            <th>nguoiQuanLy</th>
            <th>ghiChu</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${danhMucList}" var="danhMuc">
            <tr>
                <td>${danhMuc.maDM}</td>
                <td>${danhMuc.tenDanhMuc}</td>
                <td>${danhMuc.nguoiQuanLy}</td>
                <td>${danhMuc.ghiChu}</td>
                <td>
                    <a href="danhmuc?action=EDIT?id=${danhMuc.maDM}">Sửa</a>
                    <form action="danhmuc" method="POST">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${danhMuc.maDM}">
                        <button type="submit">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
