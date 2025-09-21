<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
  <title>Quản lý điện thoại</title>
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
  <h3 class="text-center">Quản lý điện thoại</h3>
  <table class="table table-striped">
    <thead class="alert alert-info">
    <tr><th>ID</th><th>Tên</th><th>Năm SX</th><th>Ảnh</th><th>Action</th></tr>
    </thead>
    <c:forEach var="dt" items="${dienthoais}">
      <tr>
        <td>${dt.id}</td>
        <td>${dt.name}</td>
        <td>${dt.namSanXuat}</td>
        <td><img src="${pageContext.request.contextPath}/uploads/${dt.hinhAnh}" width="100"/></td>
        <td>
          <form action="quanly" method="post" onsubmit="return confirm('Xóa sản phẩm?')">
            <input type="hidden" name="action" value="delete"/>
            <input type="hidden" name="id" value="${dt.id}"/>
            <button class="btn btn-danger btn-sm">Xóa</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>

  <br>
  <h6 class="text-center">
    <a href="${pageContext.request.contextPath }/dienthoais">Continue Shopping</a>
  </h6>
</div>
</body>
</html>
