<%@page import="net.fullstack7.utils.CommonUtils"%>
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
CommonUtils cUtil = new CommonUtils();
cUtil.setCookieInfo(response, request, "EL", "EL_TEST", 60);
%>

<h2>표현 언어(EL) - 내장 객체</h2>
<h3>쿠키 조회</h3>
<ul>
	<li>EL로 쿠키 조회: ${cookie.EL.value }</li>
</ul>
<hr>

<h3>HTTP 헤더 조회</h3>
<ul>
	<li>host: ${header.host }</li>
	<li>user-agent: ${header["user-agent"] }</li>
	<li>cookie: ${header.cookie }</li>
	<li>host: <%=request.getHeader("host") %></li>
	<li>user-agent: <%=request.getHeader("user-agent") %></li>
	<li>cookie: <%=request.getHeader("cookie") %></li>
</ul>

<h3>컨텍스트 초기 값 조회</h3>
<ul>
	<li>Database Driver : ${initParam.MariaDriver }
</ul>

<h3>컨텍스트 루트 값 조회</h3>
<ul>
	<li>Context Root : ${pageContext.request.contextPath }
</ul>
</body>
</html>
