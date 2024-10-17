<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		float:left;
	}
</style>
</head>
<body>
	<form action="../bbs/loginProc" method="POST">
		<table>
			<tr>
				<td><span for="id">ID : </span></td>
				<td><input type="text" id="id" name="id" value=""/></td>
			<br>
			</tr>
			<tr>
				<td><span for="pwd">PASSWORD : </span></td>
				<td><input type="password" id="pwd" name="pwd" value=""/></td>
			</tr>
		
		</table>
		<input type="submit" value="로그인"/>
	</form>
	<br><br><br><br>
	<button onclick="LinkMemberRegist()">회원가입</button>
	
<script>
	function LinkMemberRegist() {
		location.href = "memberRegist.jsp";
	}
</script>
</body>
</html>