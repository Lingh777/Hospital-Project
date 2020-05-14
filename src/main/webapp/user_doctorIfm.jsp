<%--
  Created by IntelliJ IDEA.
  User: 61043
  Date: 2020/5/14
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user_doctorIfm</title>
</head>
<body>
    <p>${doctor.dName}</p>
    <p>${doctor.introduction}</p>
    <br>
    <p>星期&nbsp;&nbsp;科室&nbsp;&nbsp;预约</p>
    <p>${doctor.date}&nbsp;&nbsp;${doctor.departmentName}&nbsp;&nbsp;<a href="">预约</a></p>
</body>
</html>
