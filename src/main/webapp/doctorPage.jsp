<%--
  Created by IntelliJ IDEA.
  User: 61043
  Date: 2020/5/11
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor Page</title>
</head>
<body>
    <a href="/hospitalProject/doctor/test/getAppointmentsByDID?dID=${requestScope.dID}">查看预约列表</a><br>
    <a href="/hospitalProject/doctor/test/getDoctorAllIfmByDID?dID=${requestScope.dID}">查看医生信息</a><br>

</body>
</html>
