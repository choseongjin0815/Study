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
<h3>인클루드된 페이지 in_page.jsp</h3>
<ul>
	<li>request 파라미터 : ${param.param1 }</li>
	<li>scope안쓴 파라미터 : ${param2 }</li>
	<li>${param.p1 }</li>
	<li>${param.p2 }</li>
</ul>


</body>
</html>