<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Enter your credentials</h1>
<c:url value="/j_spring_security_check"  var="login" />

<form action="${login}" method="POST">
<table>
	<tr>
		<td>username: </td>
		<td><input type="text" name="j_username"/></td>
	</tr>
	<tr>
		<td>password:</td>
		<td><input type="password" name="j_password"/></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="Login"/></td>
	</tr>

</table>
</form>
<font color="red">
	<span>
		${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
	</span>
	
</font>
</body>
</html>