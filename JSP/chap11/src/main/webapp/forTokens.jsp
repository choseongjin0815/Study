<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String rgba = "red,green,blue,black";
%>
<h4>JSTL 태그의 forTokens 태그 사용</h4>
<c:forTokens items="<%=rgba %>" delims="," var="color">
	<div style="color : ${color}">${color }</div>
</c:forTokens>
</body>
</html>