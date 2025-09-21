<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Danh sách sản phẩm</title>
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
        table { margin: auto; border-collapse: collapse; width: 90%; }
        th, td { border: 1px solid #333; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<main>
    <h3 style="text-align: center;">Danh sách điện thoại</h3>
    <table>
        <thead>
        <tr>
            <th>ID</th><th>Tên</th><th>Năm SX</th><th>Cấu hình</th><th>Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dt" items="${dienthoais}">
            <tr>
                <td>${dt.id}</td>
                <td>${dt.name}</td>
                <td>${dt.namSanXuat}</td>
                <td>${dt.cauHinh}</td>
                <td><img src="${pageContext.request.contextPath}/uploads/${dt.hinhAnh}" width="80"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<jsp:include page="../layout/footer.jsp"/>
</body>
</html>
