<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<style>
	table {
		text-align: center;
	}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="2">로그인</td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="login"/>
				<input type="button" value="reset"/>
			</td>
		</tr>
	</table>
</body>
</html>