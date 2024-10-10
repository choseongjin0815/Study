<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
pageContext.setAttribute("pAttr", "김유신");
request.setAttribute("rAttr", "계백");
String param = "페어런트에서 설정한 변수";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 forward</title>
</head>
<body>

<h2>액션 태그를 이용한 포워딩</h2>
<jsp:forward page="ForwardSub.jsp?param1=<%=param %>"> 포워딩한거라 쿼리스트링 안감
<jsp:param name = "param2" value = "<%=param %>"/>
</jsp:forward>
</body>
</html>
