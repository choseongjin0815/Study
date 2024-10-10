<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ page errorPage="../ErrorPage2.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

int age = Integer.parseInt(request.getParameter("age"));
out.println("현재 나이는 " + age+ "입니다.");

//try{
//	int age = Integer.parseInt(request.getParameter("age"));
//	out.println("현재 나이는 " + age+ "입니다.");
//} catch(Exception e) {
//	e.getStackTrace();
//	out.println(e.getMessage() + "<br>" + e.getClass().getName());
//}
%>


</body>
</html>