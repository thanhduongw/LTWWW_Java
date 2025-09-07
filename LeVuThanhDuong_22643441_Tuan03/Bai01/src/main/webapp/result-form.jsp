<%@ page import="iuh.fit.se.Student" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2025
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result Form</title>
</head>
<body>
<%
    Student student = new Student();
    student = (Student) request.getAttribute("student");
    out.println(
            "First Name: " + student.getFirstName() + "<br>"
            + "Last Name: " + student.getLastName() + "<br>"
            + "Birth Date: " + student.getDob() + "<br>"
            + "Email: " + student.getEmail() + "<br>"
            + "Phone: " + student.getPhone() + "<br>"
            + "Gender: " + student.getGender() + "<br>"
            + "Address: " + student.getAddress() + "<br>"
            + "City: " + student.getCity() + "<br>"
            + "State: " + student.getState() + "<br>"
            + "Pin Code: " + student.getPinCode() + "<br>"
            + "Country: " + student.getCountry() + "<br>"
            + "Hobbies: " + student.getHobbies() + "<br>"
            + "Course: " + student.getCourse() + "<br>"
    );
%>
</body>
</html>
