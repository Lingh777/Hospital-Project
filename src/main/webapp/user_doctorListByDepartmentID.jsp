<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 61043
  Date: 2020/5/14
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doctorListByDepartmentID</title>
</head>
<body>
    <c:forEach items="${requestScope.doctorList}" var="doctor">
        <a href="/hospitalProject/user/test/getDoctorAllIfmByDID?dID=${doctor.dID}">${doctor.dName}</a><br>
    </c:forEach>
</body>
</html>
