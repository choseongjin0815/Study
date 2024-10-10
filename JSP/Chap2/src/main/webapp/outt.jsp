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
<h2>out 객체 사용</h2>
<%
//버퍼 크기 정보 확인

out.print("출력 버퍼의 크기 : " + out.getBufferSize()+ "<br>");
out.print("남은 버퍼의 크기 : " + out.getRemaining()+ "<br>");
out.flush();
out.print("flush 후의 버퍼 크기  : " + out.getRemaining()+ "<br>");
%>
</body>
</html>