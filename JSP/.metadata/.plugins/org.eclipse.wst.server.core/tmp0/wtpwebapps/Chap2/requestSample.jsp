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
<h2>1. 클라이언트/서버 환경정보 조회</h2>
<a href="request1.jsp?user_id=user1&pwd=1234">GET 방식 전송</a>
<br>

<form action="request1.jsp?param1=1234&param2=abcd" method="post">
<span for="user_id">아이디 : </span>
<input type="text" name="user_id" value="user2">
<br>
<span for="pwd">비밀번호 : </span>
<input type="password" name="pwd" value="1234">
<br>
<input type="submit" value="POST 전송">
</form>

<h2>2. 클라이언트 요청 매개변수 조회</h2>
<form action="request3.jsp" method="post">
<span for="user_id2">아이디 : </span>
<input type="text" name="user_id" id="user_id2" value="user2">
<span for="pwd2">비밀번호 : </span>
<input type="password" name="pwd2" id="pwd2" value="1234">
<br>
<span for="addr1">주소 : </span>
<input type="text" name="addr1" id="addr1" value="">
<br>
<span for="addr2">상세 주소 : </span>
<input type="text" name="addr2" id="addr2" value="">
<br>
<span for="interest">좋아하는 스포츠 : </span>
<input type="radio" name="favorite" id="favorite_0" value="축구"> 축구 &nbsp;&nbsp;
<input type="radio" name="favorite" id="favorite_1" value="축구"> 농구 &nbsp;&nbsp;
<input type="radio" name="favorite" id="favorite_2" value="축구"> 배구 &nbsp;&nbsp;
<br>
<span for="interest">관심사항 : </span>
<input type="text" name="interest" id="interest_0" value="경제"> 경제 &nbsp;&nbsp;
<input type="text" name="interest" id="interest_1" value="정치"> 정치 &nbsp;&nbsp;
<input type="text" name="interest" id="interest_2" value="사회"> 사회 &nbsp;&nbsp;
<br>
<span for="introduce">소개 : </span>
<textarea name="introduce" id="introduce" value=""></textarea>
<br>
<input type="submit" value="전송">
</form>

<hr>

<h2>3.HTTP 요청 헤더 정보 조회</h2>
<a href="RequestHeader.jsp"> 요청 헤더 정보 조회







</body>
</html>