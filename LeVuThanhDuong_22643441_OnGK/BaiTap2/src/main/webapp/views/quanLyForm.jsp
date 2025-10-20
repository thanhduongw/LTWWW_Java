<%--
  Created by IntelliJ IDEA.
  User: DUONG
  Date: 20/10/2025
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý tin tức</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .nav { margin: 10px 0; }
        .nav a { margin-right: 15px; text-decoration: none; color: #0066cc; }
        .btn { padding: 5px 10px; text-decoration: none; border: 1px solid #ccc; background: #f0f0f0; }
        .btn-delete { color: red; }
    </style>
</head>
<body>
<h1>Quản lý tin tức</h1>

<div class="nav">
    <a href="${pageContext.request.contextPath}/danh-sach-tin-tuc">Danh sách tin tức</a>
    <a href="${pageContext.request.contextPath}/them-tin-tuc">Thêm tin tức</a>
</div>

<c:if test="${not empty tinTucList}">
    <table>
        <thead>
        <tr>
            <th>Mã TT</th>
            <th>Tiêu đề</th>
            <th>Nội dung</th>
            <th>Liên kết</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tt" items="${tinTucList}">
            <tr>
                <td>${tt.maTT}</td>
                <td>${tt.tieuDe}</td>
                <td>${tt.noiDung}</td>
                <td><a href="${tt.lienKet}" target="_blank">Xem chi tiết</a></td>
                <td>
                    <a href="${pageContext.request.contextPath}/quan-ly-tin-tuc?maTT=${tt.maTT}"
                       class="btn btn-delete"
                       onclick="return confirm('Bạn có chắc chắn muốn xóa tin tức này?')">
                        Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty tinTucList}">
    <p>Không có tin tức nào.</p>
</c:if>
</body>
</html>
