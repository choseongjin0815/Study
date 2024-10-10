<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,thead,tbody,th,tr,td{
	border:1px solid black;
	border-collapse:collapse;
}

th {
	text-align : center;
	width:150px;
	height : 40px;
}
.input_col {
	width:400px;
}
</style>
</head>
<body>
<h2>회원 등록</h2>

<%
%>

<ul>

</ul>
<form name="frmRegist" id="frmRegist" action="member_regist_ok.jsp" method="POST">
<table>
	<tbody>

		<tr>
			<td class="input_title">아이디 : </td>
			<td class="input_col"><input type="text"  name = "member_id" id="member_id" value="" maxlength="10"></td>
		<tr>
		<tr>
			<td class="input_title">이름 : </td>
			<td class="input_col"><input type="text" name = "name" id="name" value="" maxlength="10"></td>
		<tr>
		<tr>
			<td class="input_title">비밀번호 : </td>
			<td class="input_col"><input type="text" name = "pwd" id="pwd" value="" maxlength="10"></td>
		<tr>
		
			
	</tbody>



	<tr>
		<td colspan="4" class="align_center">
			<input type="submit" id="btnRegist" value="등록">
			<button><a href="member_list1.jsp">취소</a></button>
		</td>
	</tr>
</table>
</form>

<script>
const registBtn = document.getElementById("btnRegist");
registBtn.addEventListener('click', (e)=>{
	e.preventDefault();
	e.stopPropagation();
	const frm = document.querySelector("#frmRegist");
	const memberId = frm.member_id.value;
	const memberName = frm.name.value;
	const pwd = frm.pwd.value;
	if(memberId.length < 4 || memberId.length > 20 ) {
		alert("아이디를 4자리 이상 20자리 이하로 입력하세요.");
		frm.member_id.focus();
		return;
	}
	
	if(memberName.length < 4 || name.length > 20 ) {
		alert("이름을 4자리 이상 20자리 이하로 입력하세요.");
		frm.memberName.focus();
		return;
	}
	
	if(pwd.length < 4 || pwd.length > 20 ) {
		alert("비밀번호를 4자리 이상 20자리 이하로 입력하세요.");
		frm.pwd.focus();
		return;
	}
// 	frm.action = "member_regist_ok.jsp";
// 	frm.method = "POST";
	frm.submit();
	//location.href = "member_regist.jsp";
});

</script>
</body>
</html>