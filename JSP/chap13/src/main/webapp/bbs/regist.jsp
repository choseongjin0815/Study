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
<h2>파일업로드</h2>
<span>${errMsg }</span>
<form name="frmRegist" id="frmRegist" action="../BbsRegist.do" method="POST" enctype="multipart/form-data">
	<fieldset>
		<legend>파일업로드</legend>
		<label for="title">제목</label>
		<input type="text" name="text" id="text" value="제목 테스트 입니다."/>
		<br>
		<label for="memberId">아이디 : </label>
		<input type="text" name="memberId" id="memberId" value="user1"/>
		<br>
		<label for="content">내용 : </label>
		<textarea name = "content" id="content" style="width:600px;height:200px"></textarea>
		<br>
		<label for="fileCategory">파일 종류</label>
		<input type="radio" name="fileCategory" id="fileCategory" value="이미지"/>이미지
		<input type="radio" name="fileCategory" id="fileCategory" value="문서"/>문서
		<input type="radio" name="fileCategory" id="fileCategory" value="압축"/>압축
		<br>
		<label for="file">첨부파일 : </label>
		<input type="file" name="file" id="file"/>
		<label for="file">첨부파일(여러개가능) : </label>
		<input type="file" name="file2" id="file2" multiple/>
		<br>
		<input type="submit" value="제출"/>
		
	</fieldset>
</form>
<script>
const frm = document.getElementById("frmRegist");
frm.addEventListener("submit", function(e){
	e.preventDefault();
	e.stopPropagation();
	if(frm.memberId.value ==""){
		alert('아이디를 입력해주세요');
		frm.memberId.focus();
		return;
	}
	if(frm.title.value ==""){
		alert('제목 입력해주세요');
		frm.title.focus();
		return;
	}
	if(frm.content.value ==""){
		alert('내용 입력해주세요');
		frm.content.focus();
		return;
	}
	frm.submit();
});
</script>
</body>
</html>