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
<h2>JSTL - catch 태그</h2>
<c:set var="num1" value="100"/>
<c:catch var="e">
	<%
int num1 = 1;
int result = num1 /0;
%>
</c:catch>
${e }

<c:set var="num2" value="50"/>
<c:catch var="e2">
	${"문자열" + num2 }
</c:catch>
예외내용  : ${e2}

</body>
</html>