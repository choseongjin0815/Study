<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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

<h2>session 설정 확인</h2>
<%
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
// 최초 요청 시각
long reqTime = session.getCreationTime();
String strReqTime = sdf.format(new Date(reqTime));

long lastAccTime = session.getLastAccessedTime();
String strLastAccTime = sdf.format(new Date(lastAccTime));
%>
<ul>
	<li>세션 유지 시간 : <%=session.getMaxInactiveInterval() %>
	<li>세션 아이디 : <%=session.getId() %>
	<li>세션 최초 요청 시간 : <%=strReqTime %>
	<li>세션 마지막 요청 시간 : <%=strLastAccTime %>
	
</ul>
</body>
</html>