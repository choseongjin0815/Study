<%@page import="java.sql.PreparedStatement"%>
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
.align_center {
	text-align : center;
}
</style>
</head>
<body>
<h2>회원 목록 조회(statement)</h2>

<%
JDBConnect jdbc = new JDBConnect();
String sql = "SELECT memberId, name, pwd, regDate From tbl_member";
PreparedStatement psmt = jdbc.con.prepareStatement(sql);
ResultSet rs = psmt.executeQuery();
%>

<form id="frmList">
<table>
	
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>등록일</th>
			<th>삭제</th>
			<th>체크</th>
		</tr>
	
	<tbody>
<%
	int checkNum = 0;
	int i = 1;
	while(rs.next()) {
		
%>
		<tr>
			<td><a href="memberView.jsp?i=<%=i%>"><%=rs.getString(1)%></a></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getDate(4) %></td>
			<td><a href="member_delete_ok.jsp?name=<%=rs.getString(2)%>">삭제</a></td>
			<td><input type="checkbox" name="name" class="check" value=<%=rs.getString(2) %>></td>
		</tr>

	</tbody>
<%

	i++;
	}
jdbc.close();
%>


	<tr>
		<td><<a href="">1</a> || 
			<a>2</a>|| 
			<a>3</a>>
		</td>
	</tr>
	<tr>
		<td colspan="6" class="align_center">
			<input type="button" id="btnRegist" value="회원등록">
			<button type="submit" onclick="frmDelete()">회원삭제</button>
		</td>
	</tr>
</table>
</form>
<script>
const registBtn = document.getElementById("btnRegist");
registBtn.addEventListener('click', ()=>{
	location.href = "member_regist.jsp";
});

function frmDelete() {
	const frmL = document.querySelector("#frmList");
	frmL.action = "member_delete_ok.jsp";
}

// const deleteBtn = document.getElementById("btnDelete");
// deleteBtn.addEventListener('click', ()=>{
// 	location.href = "member_delete.jsp";
// });


const modifyBtn = document.getElementById("btnModify");
modifyBtn.addEventListener('click', ()=>{
	location.href = "member_modify.jsp";
});

</script>
</body>
</html>