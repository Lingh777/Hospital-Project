<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 61043
  Date: 2020/5/14
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DepartmentList</title>
</head>
<body>
    <c:forEach items="${requestScope.departmentList}" var="department">
        <a href="/hospitalProject/user/test/getDoctorListByDepartmentID?departmentID=${department.departmentID}">${department.departmentName}</a><br>
    </c:forEach>
</body>
</html>
