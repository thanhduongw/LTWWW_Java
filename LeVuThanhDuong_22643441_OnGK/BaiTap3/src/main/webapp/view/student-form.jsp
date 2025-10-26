<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Thông tin sinh viên</title>
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            background-color: #f7f9fc;
            padding: 40px;
        }
        .form-container {
            width: 400px;
            margin: 0 auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        label {
            display: block;
            margin-top: 12px;
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 8px;
            border-radius: 6px;
            border: 1px solid #ccc;
            margin-top: 5px;
        }
        button {
            margin-top: 20px;
            width: 100%;
            padding: 10px;
            border: none;
            background-color: #3498db;
            color: white;
            border-radius: 6px;
            cursor: pointer;
        }
        button:hover {
            background-color: #2980b9;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 10px;
            color: #555;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>${student == null ? "Thêm sinh viên" : "Cập nhật sinh viên"}</h2>

    <form action="student" method="post" id="form">
        <input type="hidden" name="action" value="${student == null ? 'add' : 'update'}">

        <label>MSSV:</label>
        <input type="text" name="mssv" value="${student.id}" ${student != null ? "readonly" : ""} required id="mssv">

        <label>Họ tên:</label>
        <input type="text" name="hoten" value="${student.name}" required id="hoten">

        <label>Ngày sinh:</label>
        <input type="date" name="ngaysinh" value="${student.dob}" required id="ngaysinh">

        <label>Điểm:</label>
        <input type="number" name="diem" step="0.1" value="${student.score}" required id="diem">

        <label>Lớp:</label>
        <select name="clazzId">
            <c:forEach items="${clazzList}" var="clazz">
                <option value="${clazz.id}" ${student != null && clazz.id == student.clazz.id ? 'selected' : ''}>${clazz.name}</option>
            </c:forEach>
        </select>

        <button type="submit">${student == null ? "Thêm mới" : "Cập nhật"}</button>
    </form>

    <a href="student">← Quay lại danh sách</a>
</div>

<script>
    document.getElementById('form').addEventListener("submit",(e)=>{
        const mssv=document.getElementById('mssv').value.trim();
        const hoten=document.getElementById('hoten').value.trim();
        const ngaysinh=document.getElementById('ngaysinh').value.trim();
        const diem=document.getElementById('diem').value.trim();

        const mssvRegex = /^\d{6}$/;
        const hotenRegex = /^[A-Za-z\s]+$/;
        const diemRegex = /^(?:10(?:\.0+)?|[0-9](?:\.\d+)?)$/;
        if(!mssvRegex.test(mssv)){
            alert("MSSV phải chứa 6 số")
            e.preventDefault()
        }
        if(!hotenRegex.test(hoten)){
            alert("Tên không được chứa số hoặc ký tự đặc biệt");
            e.preventDefault()
        }
        if(!diemRegex.test(diem)){
            alert("Điểm phải từ 0 đến 10")
            e.preventDefault()
        }

    })
</script>

</body>
</html>