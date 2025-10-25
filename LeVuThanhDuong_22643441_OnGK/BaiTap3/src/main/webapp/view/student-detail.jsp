<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Chi tiết sinh viên</title>
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            background-color: #f5f7fa;
            padding: 40px;
        }
        .detail-box {
            width: 400px;
            margin: 0 auto;
            background-color: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        p {
            font-size: 15px;
            margin: 10px 0;
        }
        span {
            font-weight: bold;
            color: #34495e;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #3498db;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="detail-box">
    <h2>Thông tin sinh viên</h2>

    <p><span>MSSV:</span> ${student.id}</p>
    <p><span>Họ tên:</span> ${student.name}</p>
    <p><span>Ngày sinh:</span> ${student.dob}</p>
    <p><span>Điểm:</span> ${student.score}</p>
    <p><span>Lớp:</span> ${student.clazz.name}</p>

    <a href="student">← Quay lại danh sách</a>
</div>

</body>
</html>
