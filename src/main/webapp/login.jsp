<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>用户登陆</p>
	<form action="user/test/login" method="post">
		uID:<input type="text" required="required"  name="uID"><br>
		uPwd:<input type="password" required="required"  name="uPwd"><br>
		<input type="submit" value="login">
    </form>

	<br>
	<p>医生登陆</p>
	<form action="doctor/test/login" method="post">
		uID:<input type="text" required="required"  name="dID"><br>
		uPwd:<input type="password" required="required"  name="dPwd"><br>
		<input type="submit" value="login">
	</form>


</body>
</html>