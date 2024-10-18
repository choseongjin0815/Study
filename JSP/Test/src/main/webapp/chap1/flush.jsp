<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer ="1kb" autoFlush="true" %>
<%@ page trimDirectiveWhitespaces = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(int i = 1; i <= 1000; i++){
	out.println("12345");
}
%>
</body>
</html>