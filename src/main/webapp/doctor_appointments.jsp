<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 61043
  Date: 2020/5/11
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>appointments</title>
</head>
<body>
    <c:forEach items="${requestScope.appointments}" var="appointment">
        <p>${appointment.appointmentID}&nbsp;&nbsp;${appointment.uID}&nbsp;&nbsp;${appointment.date}</p>
    </c:forEach>
</body>
</html>
