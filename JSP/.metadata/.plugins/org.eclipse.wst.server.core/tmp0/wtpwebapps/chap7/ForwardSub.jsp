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
aaaa
<h2>포워드 결과</h2>
<ul>
	<li>page 영역 :  <%=pageContext.getAttribute("pAttr") %></li>
	<li>request 영역 :  <%=request.getAttribute("rAttr") %></li>
	<li>param1 : <%=request.getParameter("param1") %></li>
	<li>param2 : <%=request.getParameter("param2") %></li>
</ul>
</body>
</html>