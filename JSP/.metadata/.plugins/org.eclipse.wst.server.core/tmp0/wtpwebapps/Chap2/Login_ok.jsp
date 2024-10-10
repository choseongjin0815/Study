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
<h2>로그인 처리</h2>
<%
String user_id = request.getParameter("user_id");
String pwd = request.getParameter("pwd");
if(user_id.equals("user1") && pwd.equalsIgnoreCase("1")) {
	response.sendRedirect("login.jsp?loginErr=1");
}
else {
	request.getRequestDispatcher("login.jsp?loginErr=1").forward(request, response);
}
%>
</body>
</html>