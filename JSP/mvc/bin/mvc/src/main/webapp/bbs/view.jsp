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
</style>
</head>
<body>
<button onclick="logoutLink()">로그아웃</button>
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
	
	<tr>
		<td>${bbsList[param.idx - 1].idx }</td>
		<td>${bbsList[param.idx - 1].title }</td>
		<td>${bbsList[param.idx - 1].memberId }</td>
		<td>${bbsList[param.idx - 1].content }</td>
		<td>${bbsList[param.idx - 1].regDate }</td>
		<td>${bbsList[param.idx - 1].modifyDate }</td>
		<td>${bbsList[param.idx - 1].readCnt }</td>
		
	<tr/>
</table>
<br><br>
<button onclick="modifyLink()">게시글수정</button>

<script>
function logoutLink(){
    location.href = "../bbs/loginProc";
}
function modifyLink(){
    location.href = "modify.jsp?idx=${bbsList[param.idx - 1].idx}&memberId=${bbsList[param.idx - 1].memberId}";
}
</script>
</body>
</html>