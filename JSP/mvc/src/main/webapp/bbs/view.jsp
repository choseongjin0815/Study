<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td {
	border : 1px solid skyblue; 
}
textarea {
	width : 300px;
	height : 110px;
	resize : none;
}
</style>
</head>
<body>
<button onclick="logoutLink()">로그아웃</button>
<button onclick="modifyLink()">게시글수정</button>
<table>
	<tr>
		<td>idx</td>
		<td>title</td>
		<td>memberId</td>
		<td>content</td>
		<td>regDate</td>
		<td>modifyDate</td>
		<td>readCnt</td>
	</tr>
	
	<c:set var="bbs" value="${bbs }"/>
	<tr>
		<td>${bbs.idx }</td>
		<td>${bbs.title }</td>
		<td>${bbs.memberId }</td>
		<td>${bbs.content }</td>
		<td>${bbs.regDate }</td>
		<td>${bbs.modifyDate }</td>
		<td>${bbs.readCnt }</td>
		
	<tr/>
</table>
<br><br>

<br><br>
<h2>댓글</h2>

<form action="../bbs/comment" method="GET">
	<input type="hidden" name="idx" value="${bbs.idx }"/>
	<textarea type="text" name="content"></textarea>
	<input type="submit" value="${bbs.idx }번호 게시글 댓글등록"/>	
</form>

<script>

function logoutLink(){
    location.href = "../bbs/loginProc";
}
function modifyLink(){
    location.href = "modify.jsp?idx=${bbs.idx}&memberId=${bbs.memberId}";
}
</script>
</body>
</html>