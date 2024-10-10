<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@page import ="dto.StudentDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>request forward로 영역</h2>
<%
String reqType = request.getParameter("reqType");
%>
<h2><%=(reqType!=null && reqType.equals("req") ? "request foward" : "send")%></h2>
<%
Object req1 = request.getAttribute("req1");
Object reqStudent = request.getAttribute("reqStudent");
%>
<%
	StudentDTO std3 = null;
	if(reqStudent != null) {
		std3 = (StudentDTO)reqStudent;
	}
%>
<ul>
	<li><%=(std3 != null ? std3.getNo() : "null")%></li>
	<li><%=(std3 != null ? std3.getName() : "null") %></li>
	<li><%=(std3 != null ? std3.getAge() : "null") %></li>
	<li><%=(std3 != null ? std3.getDept() : "null") %></li>
	<li><%=(std3 != null ? std3.getGrade() : "null") %></li>
	<li>request user_id : <%=request.getParameter("user_id") %></li>
	<li>request pwd : <%=request.getParameter("pwd") %></li>
</ul>

<%

%>
</body>
</html>