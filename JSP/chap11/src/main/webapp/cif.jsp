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
<h2>JSTL - core - if</h2>
<c:set var="num1" value="11"/>
<c:set var="str1" value="테스트"/>

<h3>JSTL IF 태그로 짝수/홀수 판별</h3>
<c:if test="${num1 mod 2 eq 0 }" var="even">
	${num1 }은 짝수
</c:if>

<c:if test="${not even }" var="odd">
	${num1 }은 홀수
</c:if>
<%-- <br>odd : ${odd } --%>
<c:if test="${not empty odd}" var="odd_result">
<%-- <br> odd: ${odd } --%>
</c:if>

<c:if test="${str1 eq '테스트'}" var="str1Result">
 문자열은 ${str1}입니다.
</c:if>
<c:if test="${not str1Result}">
 문자열은 테스트가 아닙니다.
</c:if>

<c:if test="${true }">
	<br> true
</c:if>

<c:if test=" ${true }" var="chk">
	<br> 
</c:if>
<br>${chk}
<c:if test="True">
	<br> true
</c:if>
<c:if test="tRue" var="tResult">
	<br> tRue
</c:if> 
true들어가면(대소문자구분x) true 거꾸로 false도 똑같음 공백이 있으면 안된다.
<br>${tResult }


<c:if test="fALse" var="tResult2">
</c:if>
<br>${tResult2 } 
</body>
</html>