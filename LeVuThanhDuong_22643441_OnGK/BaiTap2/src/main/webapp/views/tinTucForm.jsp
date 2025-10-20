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
  <title>Thêm tin tức</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    .form-group { margin: 10px 0; }
    label { display: block; margin-bottom: 5px; }
    input, textarea, select { width: 300px; padding: 5px; }
    .error { color: red; font-size: 14px; }
    .nav { margin: 10px 0; }
    .nav a { margin-right: 15px; text-decoration: none; color: #0066cc; }
  </style>
</head>
<body>
<h1>Thêm tin tức mới</h1>

<div class="nav">
  <a href="${pageContext.request.contextPath}/danh-sach-tin-tuc">Danh sách tin tức</a>
  <a href="${pageContext.request.contextPath}/quan-ly-tin-tuc">Quản lý tin tức</a>
</div>

<c:if test="${not empty error}">
  <p class="error">${error}</p>
</c:if>

<form method="post">
  <div class="form-group">
    <label for="tieuDe">Tiêu đề:</label>
    <input type="text" id="tieuDe" name="tieuDe"
           value="${tinTuc.tieuDe}" required>
    <c:if test="${not empty errors}">
      <c:forEach var="error" items="${errors}">
        <c:if test="${error.propertyPath == 'tieuDe'}">
          <div class="error">${error.message}</div>
        </c:if>
      </c:forEach>
    </c:if>
  </div>

  <div class="form-group">
    <label for="noiDung">Nội dung:</label>
    <textarea id="noiDung" name="noiDung" rows="4"
              required>${tinTuc.noiDung}</textarea>
    <c:if test="${not empty errors}">
      <c:forEach var="error" items="${errors}">
        <c:if test="${error.propertyPath == 'noiDung'}">
          <div class="error">${error.message}</div>
        </c:if>
      </c:forEach>
    </c:if>
  </div>

  <div class="form-group">
    <label for="lienKet">Liên kết:</label>
    <input type="text" id="lienKet" name="lienKet"
           value="${tinTuc.lienKet}" required>
    <c:if test="${not empty errors}">
      <c:forEach var="error" items="${errors}">
        <c:if test="${error.propertyPath == 'lienKet'}">
          <div class="error">${error.message}</div>
        </c:if>
      </c:forEach>
    </c:if>
  </div>

  <div class="form-group">
    <label for="maDM">Danh mục:</label>
    <select id="maDM" name="maDM" required>
      <option value="">--Chọn danh mục--</option>
      <c:forEach var="dm" items="${danhMucList}">
        <option value="${dm.maDanhMuc}"
          ${dm.maDanhMuc == tinTuc.danhMuc.maDanhMuc ? 'selected' : ''}>
            ${dm.tenDanhMuc}
        </option>
      </c:forEach>
    </select>
    <c:if test="${not empty errors}">
      <c:forEach var="error" items="${errors}">
        <c:if test="${error.propertyPath == 'maDM'}">
          <div class="error">${error.message}</div>
        </c:if>
      </c:forEach>
    </c:if>
  </div>

  <button type="submit">Thêm tin tức</button>
</form>
</body>
</html>
