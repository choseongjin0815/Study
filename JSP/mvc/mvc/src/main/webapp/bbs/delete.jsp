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
<form action="../bbs/delete" method="POST">
	<span for="idx">삭제할 IDX : </span>
	<input type="text" id="idx" name="idx" value=""/><br>
	<input type="submit" value="삭제"/>
</form>
</body>
</html>