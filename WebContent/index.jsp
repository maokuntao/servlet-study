<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet Study</title>
</head>
<body>
	<h1>updateFirstNameByid</h1>
	<form action="jdbcServlet" method="post">
		firstName : <input type="text" name="firstName" /><br> id : <input
			type="text" name="id" /><br>
		<button name="submit">确认修改</button>
	</form>
</body>
</html>