<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách tin tức</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .nav a { margin-right: 15px; text-decoration: none; color: #0066cc; }
        .filter-section { background-color: #f9f9f9; padding: 15px; margin: 15px 0; border-radius: 5px; }
        .stats { margin: 10px 0; color: #666; }
    </style>
</head>
<body>
<h1>Danh sách tin tức</h1>

<div class="nav">
    <a href="${pageContext.request.contextPath}/them-tin-tuc">Thêm tin tức</a>
    <a href="${pageContext.request.contextPath}/quan-ly-tin-tuc">Quản lý tin tức</a>
</div>

<div class="filter-section">
    <h3>Lọc tin tức theo danh mục</h3>
    <form method="get">
        <label for="maDM">Chọn danh mục:</label>
        <select name="maDM" id="maDM" onchange="this.form.submit()">
            <option value="">--Tất cả danh mục--</option>
            <c:forEach var="dm" items="${danhMucList}">
                <option value="${dm.maDanhMuc}"
                        <c:if test="${selectedMaDM != null and dm.maDanhMuc eq selectedMaDM}">selected</c:if>>
                        ${dm.tenDanhMuc}
                </option>
            </c:forEach>
        </select>
        <c:if test="${selectedMaDM != null}">
            <a href="${pageContext.request.contextPath}/danh-sach-tin-tuc"
               style="margin-left: 10px; color: #cc0000; text-decoration: none;">[Xóa lọc]</a>
        </c:if>
    </form>

    <div class="stats">
        <c:choose>
            <c:when test="${selectedMaDM != null}">
                Đang hiển thị tin tức của danh mục đã chọn
                (${not empty tinTucList ? tinTucList.size() : 0} tin tức)
            </c:when>
            <c:otherwise>
                Đang hiển thị tất cả tin tức
                (${not empty tinTucList ? tinTucList.size() : 0} tin tức)
            </c:otherwise>
        </c:choose>
    </div>
</div>

<c:if test="${not empty tinTucList}">
    <table>
        <thead>
        <tr>
            <th>Mã TT</th>
            <th>Tiêu đề</th>
            <th>Nội dung</th>
            <th>Liên kết</th>
            <th>Danh mục</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="tt" items="${tinTucList}">
            <tr>
                <td>${tt.maTT}</td>
                <td><strong>${tt.tieuDe}</strong></td>
                <td>
                    <c:choose>
                        <c:when test="${not empty tt.noiDung and tt.noiDung.length() > 100}">
                            ${tt.noiDung.substring(0,100)}...
                        </c:when>
                        <c:otherwise>
                            ${tt.noiDung}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${not empty tt.lienKet}">
                        <a href="${tt.lienKet}" target="_blank" style="color: #0066cc; text-decoration: none;">📎 Xem chi tiết</a>
                    </c:if>
                </td>
                <td>${tt.danhMuc.tenDanhMuc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty tinTucList}">
    <p style="text-align: center; color: #666; padding: 20px;">
        <c:choose>
            <c:when test="${selectedMaDM != null}">
                Không có tin tức nào trong danh mục này.
            </c:when>
            <c:otherwise>
                Chưa có tin tức nào. <a href="${pageContext.request.contextPath}/them-tin-tuc">Thêm tin tức mới</a>
            </c:otherwise>
        </c:choose>
    </p>
</c:if>

<c:if test="${not empty error}">
    <p style="color: red; background-color: #ffe6e6; padding: 10px; border-radius: 5px;">
            ${error}
    </p>
</c:if>

</body>
</html>
