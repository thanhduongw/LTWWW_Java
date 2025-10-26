<%--
  Created by IntelliJ IDEA.
  User: DUONG
  Date: 25/10/2025
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh mục Form</title>
</head>
<body>
<a href="danhmuc">Quay lại trang danh sách danh mục</a>
<form action="danhmuc" method="post">
    <input type="hidden" name="action" value="save">

        <label>maDM</label>
        <input type="text" name="maDM" value="${danhMuc.maDM}">

    <label>tenDanhMuc</label>
    <input type="text" name="tenDanhMuc" value="${danhMuc.tenDanhMuc}" required>
    <label>nguoiQuanLy</label>
    <input type="text" name="nguoiQuanLy" value="${danhMuc.nguoiQuanLy}" required>
    <label>ghiChu</label>
    <input type="text" name="ghiChu" value="${danhMuc.ghiChu}" required>
    <button type="submit">Save</button>
</form>
</body>
</html>
