<%--
  Created by IntelliJ IDEA.
  User: 61043
  Date: 2020/5/12
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
    <a href="/hospitalProject/user/test/getDepartmentList">获取科室列表</a>
    <a href="/hospitalProject/user/test/getUserAllIfmByUID?uID=${requestScope.uID}">获取全部信息</a>
    <a href="/hospitalProject/user/getAppointmentsByUID?uID=${requestScope.uID}">获取预约信息</a>
</body>
</html>
