<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Thêm sản phẩm</title>
  <style>
    html, body {
      height: 100%;
      margin: 0;
      display: flex;
      flex-direction: column;
    }
    main {
      flex: 1;
    }
  </style>
</head>
<body style="border: 1px solid #000">
<jsp:include page="../layout/header.jsp"/>
<main>
  <h3 style="text-align: center;">Thêm mới điện thoại</h3>
  <form method="post" action="${pageContext.request.contextPath}/dienthoai-form" enctype="multipart/form-data" style="width: 60%; margin: auto;">
    <label>Mã ĐT:</label><input type="text" name="id" required/><br/><br/>
    <label>Tên:</label><input type="text" name="ten" required/><br/><br/>
    <label>Năm SX:</label><input type="text" name="nam" required/><br/><br/>
    <label>Cấu hình:</label><input type="text" name="cauHinh" maxlength="255" required/><br/><br/>
    <label>Nhà cung cấp ID:</label><input type="text" name="nccId" required/><br/><br/>
    <label>Ảnh:</label><input type="file" name="image" accept=".png,.jpg,.jpeg" required/><br/><br/>
    <button type="submit">Thêm</button>
  </form>
</main>
<jsp:include page="../layout/footer.jsp"/>
</body>
</html>
