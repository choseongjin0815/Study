<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="../bbs/memberRegist" method="POST">
	<table>
		<tr>
			<td>이름 : </td>
			<td><input type="text" name="name" id="name" value=""/></td>
		</tr>
		<tr>
			<td>ID : </td>
			<td><input type="text" name="id" id="id" value=""/></td>
		</tr>
		<tr>
			<td>PWD : </td>
			<td><input type="password" name="pwd" id="pwd" value=""/></td>
		</tr>
		<tr>
			<td><input type="submit" value="완료"/></td>
		</tr>
		
	</table>
</form>
</body>
</html>