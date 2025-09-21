<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Danh sách tin tức</title></head>
<body>
<h2>Danh mục</h2>
<ul>
    <c:forEach var="dm" items="${danhmucs}">
        <li>
            <a href="${pageContext.request.contextPath}/danh-sach?madm=${dm.id}">
                    ${dm.name}
            </a>
        </li>
    </c:forEach>
</ul>

<h2>Danh sách tin tức</h2>
<c:if test="${empty tinTucs}">
    <p>Không có tin tức.</p>
</c:if>
<ul>
    <c:forEach var="t" items="${tinTucs}">
        <li>
            <strong>${t.title}</strong> - ${t.content} -
            <a href="${t.link}" target="_blank">${t.link}</a>
        </li>
    </c:forEach>
</ul>

<p><a href="${pageContext.request.contextPath}/tin-tuc-form">Thêm tin tức mới</a> |
    <a href="${pageContext.request.contextPath}/quan-ly">Quản lý (xóa)</a></p>
</body>
</html>