<%--
  Created by IntelliJ IDEA.
  User: DUONG
  Date: 26/10/2025
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="dienthoai" method="get">
    <select name="maNCC">
        <option value="ALL">All</option>
        <c:forEach items="${nhaCungCapList}" var="ncc">
            <option value="${ncc.maNCC}">${ncc.tenNCC}</option>
        </c:forEach>
    </select>
    <button type="submit">Lọc</button>
</form>

<table border="1">
    <tr>
        <th>maDT</th>
        <th>tenDT</th>
        <th>namSanXuat</th>
        <th>cauHinh</th>
        <th>nhaCungCap</th>
        <th>hinhAnh</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${dienThoaiList}" var="dienThoai">
        <tr>
            <td>${dienThoai.maDT}</td>
            <td>${dienThoai.tenDT}</td>
            <td>${dienThoai.namSanXuat}</td>
            <td>${dienThoai.cauHinh}</td>
            <td>${dienThoai.nhaCungCap.tenNCC}</td>
            <td>
                <img src="${pageContext.request.contextPath}/images/${dienThoai.hinhAnh}" width="120">
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
