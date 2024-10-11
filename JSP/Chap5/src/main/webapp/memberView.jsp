<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>

<%
JDBConnect jdbc = new JDBConnect();
String sql = "SELECT memberId, name, pwd, regDate From tbl_member";
Statement stmt = jdbc.con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

String id = "";
String name ="";
String pwd ="";

int i = Integer.parseInt(request.getParameter("i"));
int j = 1;
while(rs.next()) {
	if(i==j) {
		id = rs.getString(1);
		name = rs.getString(2);
		pwd = rs.getString(3);
	}
	j++;
}

%>
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
			<td class="input_col"><%=id %></td>
		<tr>
		<tr>
			<td class="input_title">이름 : </td>
			<td class="input_col"> <%=name %></td>
		<tr>
		<tr>
			<td class="input_title">비밀번호 : </td>
			<td class="input_col"><%=pwd %><td>
		<tr>
		
			
	</tbody>



	<tr>
		<td colspan="4" class="align_center">
			<button><a href="member_list1.jsp" style="text-decoration:none">처음으로</a></button>
			<button><a href="member_modify.jsp?id=<%=id%>&name=<%=name%>&pwd=<%=pwd%>">회원수정</a></button>
		
		</td>
	</tr>
</table>
</form>

<script>

const modifyBtn = document.getElementById("btnModify");
modifyBtn.addEventListener('click', ()=>{
	location.href = "member_modify.jsp";
});

</script>
</body>
</html>