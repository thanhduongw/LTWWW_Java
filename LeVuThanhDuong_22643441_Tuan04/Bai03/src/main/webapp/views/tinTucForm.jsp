<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Thêm tin tức</title></head>
<body>
<h2>Thêm tin tức</h2>

<c:if test="${not empty errors}">
    <div style="color:red;">
        <c:forEach var="e" items="${errors}">
            <p>${e.value}</p>
        </c:forEach>
    </div>
</c:if>

<form action="${pageContext.request.contextPath}/tin-tuc-form" method="post">
    <label>Mã TT: <input type="text" name="maTT" value="${tinTuc.maTT}"/></label><br/>
    <label>Tiêu đề: <input type="text" name="tieuDe" value="${tinTuc.tieuDe}"/></label><br/>
    <label>Nội dung: <textarea name="noiDung" maxlength="255">${tinTuc.noiDung}</textarea></label><br/>
    <label>Liên kết: <input type="text" name="lienKet" value="${tinTuc.lienKet}"/></label><br/>
    <label>Danh mục:
        <select name="maDM">
            <option value="">-- Chọn --</option>
            <c:forEach var="dm" items="${danhmucs}">
                <option value="${dm.maDM}" <c:if test="${dm.maDM == tinTuc.maDM}">selected</c:if>>
                        ${dm.tenDanhMuc}
                </option>
            </c:forEach>
        </select>
    </label><br/>
    <button type="submit">Thêm</button>
</form>

<p><a href="${pageContext.request.contextPath}/danh-sach">Quay về danh sách</a></p>
</body>
</html>
