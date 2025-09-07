<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="registration-form" name="formDangKy" method="GET">
    <table>
        <tr>
            <td>First name: </td>
            <td><input type="text" name="firstName" value="" size="30"/></td>
        </tr>
        <tr>
            <td>Last name: </td>
            <td><input type="text" name="lastName" value="" size="30"/></td>
        </tr>
        <tr>
            <td>Day of birth: </td>
            <td><input type="date" name="dob"></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><input type="email" name="email" value="" size="30"/></td>
        </tr>
        <tr>
            <td>Phone number: </td>
            <td><input type="tel" name="phone" value="" size="30"/></td>
        </tr>
        <tr>
            <td>Gender: </td>
            <td colspan="2">
                Male <input type="radio" name="gender" value="male">
                Female<input type="radio" name="gender" value="female">
            </td>
        </tr>
        <tr>
            <td>Address: </td>
            <td><input type="text" name="address" value="" size="40"/></td>
        </tr>
        <tr>
            <td>City: </td>
            <td><input type="text" name="city" value="" size="30"/></td>
        </tr>
        <tr>
            <td>Pin code: </td>
            <td><input type="text" name="pinCode" value="" size="30"/></td>
        </tr>
        <tr>
            <td>State: </td>
            <td><input type="text" name="state" value="" size="30"/></td>
        </tr>
        <tr>
            <td>Country: </td>
            <td><input type="text" name="country" value="" size="30"/></td>
        </tr>
        <tr>
            <td>Hobbies: </td>
            <td colspan="5">
                Drawing <input type="checkbox" name="hobbies" value="drawing">
                Singing <input type="checkbox" name="hobbies" value="singing">
                Dancing <input type="checkbox" name="hobbies" value="dancing">
                Sketching <input type="checkbox" name="hobbies" value="sketching">
                Other <input type="checkbox" name="hobbies" value="other">
                <input type="text" name="hobbies" value="other">
            </td>
        </tr>
        <tr>
            <td>Qualification: </td>
            <td>
                <table>
                    <tr>
                        <th>SI.No.</th>
                        <th>Examination</th>
                        <th>Board</th>
                        <th>Percentage</th>
                        <th>Year of Passing</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Class X</td>
                        <td><input type="text" name="boardX" value="" size="15"/></td>
                        <td><input type="text" name="percentageX" value="" size="15"/></td>
                        <td><input type="text" name="yearX" value="" size="15"/></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Class XII</td>
                        <td><input type="text" name="boardXII" value="" size="15"/></td>
                        <td><input type="text" name="percentageXII" value="" size="15"/></td>
                        <td><input type="text" name="yearXII" value="" size="15"/></td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Graduation</td>
                        <td><input type="text" name="boardGrad" value="" size="15"/></td>
                        <td><input type="text" name="percentageGrad" value="" size="15"/></td>
                        <td><input type="text" name="yearGrad" value="" size="15"/></td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>Masters</td>
                        <td><input type="text" name="boardMasters" value="" size="15"/></td>
                        <td><input type="text" name="percentageMasters" value="" size="15"/></td>
                        <td><input type="text" name="yearMasters" value="" size="15"/></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>Course applies for: </td>
            <td colspan="4">
                BCA <input type="radio" name="course" value="BCA">
                BCom <input type="radio" name="course" value="BCom">
                BSc <input type="radio" name="course" value="BSc">
                BA <input type="radio" name="course" value="BA">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </td>
    </table>
</form>
</body>
</html>