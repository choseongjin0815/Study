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
<form name="frmDelete" id="frmDelete" action="member_delete_ok.jsp" method="POST">
<table>
	<tbody>
		<tr>
			<td class="input_title">이름 : </td>
			<td class="input_col"><input type="text" name = "name" id="name" value="" maxlength="10"></td>
		<tr>
			
	</tbody>



	<tr>
		<td colspan="4" class="align_center">
			<button type="submit" id="btnDelete">삭제</button>
			<button><a href="member_list1.jsp">취소</a></button>
		</td>
	</tr>
</table>
</form>

<script>
const registDel = document.getElementById("btnDelete");
registDel.addEventListener('click', (e)=>{
	e.preventDefault();
	e.stopPropagation();
	const frm = document.querySelector("#frmDelete");	
	const memberName = frm.name.value;
	if(memberName.length == 0 ) {
		alert("삭제할 이름을 입력하세요;");
		frm.member_id.focus();
		return;
	} 
	
// 	frm.method = "POST";
	frm.submit();
	//location.href = "member_regist.jsp";
});

</script>
</body>
</html>