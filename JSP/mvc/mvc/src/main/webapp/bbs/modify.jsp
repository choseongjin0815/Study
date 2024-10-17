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

<button onclick="logoutLink()">로그아웃</button>
<form action="../bbs/modify" method="POST" enctype="multipart/form-data">
	<span for="idx">정보 수정을 원하는 idx : </span>
	<input type="text" id="idx" name="idx" value="${param.idx }"/>
	<br>
	<span for="memberId">정보 수정을 원하는 Id : </span>
	<input type="text" id="memberId" name="memberId" value="${param.memberId }"/>
	<br>
	<span for="title">수정할 제목 : </span>
	<input type="text" id="title" name="title" value=""/>
	<br>
	<span for="content">수정할 내용 : </span>
	<input type="text" id="content" name="content" value=""/>
	<br>
	<span for="filecategory_0">파일 종류 : </span>
	<input type="checkbox" name="filecategory" id="filecategory_0" value="문서"/>문서
	<input type="checkbox" name="filecategory" id="filecategory_1" value="이미지"/>이미지
	<input type="checkbox" name="filecategory" id="filecategory_2" value="압축파일"/>압축파일
	<br>
	<input type="file" name="newFile" id="newFile"/>
	<br>
	<input type="submit" value="수정"/>

</form>
<script>
	function logoutLink(){
	    location.href = "../bbs/loginProc";
	}
</script>
</body>
</html>