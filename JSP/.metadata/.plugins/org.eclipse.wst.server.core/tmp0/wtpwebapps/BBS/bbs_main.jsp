<%@page import="fullstack7.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String idValue = (String)session.getAttribute("mid"); 
String pwdValue = (String)session.getAttribute("mpwd"); 
String check = (String)session.getAttribute("mflag");

MemberDTO memberDTO = new MemberDTO();
if(check != null && check.equals("Y")) {
	check = "checked";
}
if(idValue == null) {
	idValue = "";
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<%
if(pwdValue == null) {
	
%>
<form id = "frm_main" method="POST">
<span for="login_id">ID : </span>
<input type="text" id="login_id" name="login_id" value="<%=idValue%>">
<input type="checkbox" name="auto_id_flag" value="Y" <%=check%>>ID 저장
<br>
<span for="login_pwd">PWD : </span>
<input type="password" id="login_pwd" name="login_pwd" value="">
<button type="submit" id="login_btn" onclick="frmLogin()">로그인</button>
</form>
<%
}
else {
	out.print(idValue + " " + pwdValue);
%>
<button><a href="bbs_logout.jsp">로그아웃</a></button>
<%
}
%>
<script>
function frmLogin(){
	const frm = document.querySelector("#frm_main");
	frm.action = "bbs_login_ok.jsp";
}


</script>
</body>
</html>