<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ include file = "Inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>include 지시어</h2>
<%
 out.println("Today : " + today + "내일 : " + tomorrow);
%>
</body>
</html>