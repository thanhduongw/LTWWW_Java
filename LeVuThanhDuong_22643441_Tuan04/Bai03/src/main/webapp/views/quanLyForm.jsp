<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Quản lý tin tức</title></head>
<body>
<h2>Quản lý tin tức</h2>

<table border="1" cellpadding="5">
    <tr><th>Mã</th><th>Tiêu đề</th><th>Nội dung</th><th>Liên kết</th><th>Danh mục</th><th>Hành động</th></tr>
    <c:forEach var="t" items="${tintucs}">
        <tr>
            <td>${t.id}</td>
            <td>${t.title}</td>
            <td>${t.content}</td>
            <td><a href="${t.link}" target="_blank">Xem</a></td>
            <td>${t.danhMuc.name}</td>
            <td>
                <form action="${pageContext.request.contextPath}/quan-ly" method="post" onsubmit="return confirm('Xóa tin này?');">
                    <input type="hidden" name="maTT" value="${t.maTT}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="submit">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<p><a href="${pageContext.request.contextPath}/danh-sach">Về trang danh sách</a></p>
</body>
</html>
