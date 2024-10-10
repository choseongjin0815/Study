<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%

String member_id = (String)session.getAttribute("memberId");
if(member_id == null) {
	member_id = "";
}
String check = (String)session.getAttribute("save_id_flag");
if(check != null && check.equals("Y")){
	check = "checked";
	member_id = (String)session.getAttribute("saveId");
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>로그인 페이지</h2>
<form name="frmLogin" id="frmLogin" action="Login_ok.jsp" method="post">
<%if (member_id.equals("")) { %>
	<span for="user_id">아이디</span> <input type="text" id="user_id" name="memberId" value="<%=member_id %>" maxlength="20">
	<input type="checkbox" id="save_id_flag" name="save_id_flag" value="Y" <%=check %>><span for="save_id_flag" maxlength="20">아이디 저장</span>
	<br><br>
	<span for="pwd">비밀번호</span> <input type="password" id="pwd" name="pwd" value="">
	<br><br>
	<input type="submit" id="btnLogin" value="로그인">
<%
}
else {
	out.print(member_id + "회원님, 로그인하셨습니다.");
%>
<button type="submit" onclick="frmLogout()">로그아웃</button>

<%
}
%>
</form>
<script>
function frmLogout() {
	const frmL = document.querySelector("#frmLogin");
	frmL.action = "logout.jsp";
}
</script>
</body>
</html>