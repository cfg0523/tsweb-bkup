<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="<c:url value='/sys/login'/>" method="post">
		Username: <input type="text" name="username" value="hayden" /><br />
		Password: <input type="text" name="password" value="qiannianhu" /><br />
		<input type="submit" name="submit" value="Submit" />
	</form>
</body>
</html>