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
<%
String param2 = "include 지시어 지시창에서 만든 변수";

%>
<h2>인클루드 지시어로 포함된 페이지</h2>
<ul>
	<li>page 영역 : <%=pageContext.getAttribute("param1") %>
	<li>request 영역 : <%=request.getAttribute("param2") %>
</ul>
</body>
</html>