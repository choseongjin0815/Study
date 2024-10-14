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
<h2>useBean 액션태그</h2>
<h3>자바빈즈 생성</h3>
<jsp:useBean id="member" class="fullstack7.member.MemberDTO" scope="request"/>
<!--같은 표현임 MemberDTO memberDTO = new MemberDTO(); -->
<br>
<h3>프로퍼티 설정</h3>
<br> ==> member.setMemberId("user1")
<br> ==> member.setName("홍길동")
<br> ==> member.setPwd("1234")
<jsp:setProperty property="memberId" name="member" value="user1"/>
<jsp:setProperty property="name" name="member" value="홍길동"/>
<jsp:setProperty property="pwd" name="member" value="1234"/>

<h3>프로퍼티 조회</h3>
<ul>
	<li>아이디 : <jsp:getProperty name="member" property="memberId"/> </li>
	<li>아이디 : <jsp:getProperty name="member" property="name"/> </li>
	<li>아이디 : <jsp:getProperty name="member" property="pwd"/> </li>
</ul>

<br> ==> member.setMemberId("user1")
<br> ==> member.setName("홍길동")
<br> ==> member.setPwd("1234")

<hr>

<jsp:setProperty property="*" name="member"/>




</body>
</html>