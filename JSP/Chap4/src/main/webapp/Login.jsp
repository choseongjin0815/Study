<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
String LoginId = "";
String loginFlag ="";
String check = "";
Cookie[] cookies = request.getCookies();
if(cookies != null) {
	for(Cookie c : cookies) {
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		String flagName = c.getName();
		String flagValue = c.getValue();
		if(cookieName.equals("autoId")){
			LoginId = cookieValue;
		}
		if(flagName.equals("loginflag")){
			check = flagValue;
		}
	}
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
	<span for="user_id">아이디</span> <input type="text" id="user_id" name="user_id" value="<%=LoginId %>" maxlength="20">
	<input type="checkbox" id="save_id_flag" name="save_id_flag" value="Y" <%=check %>><span for="save_id_flag" maxlength="20">아이디 저장</span>
	<br><br>
	<span for="pwd">비밀번호</span> <input type="password" id="pwd" name="pwd" value="">
	<br><br>
	<input type="submit" id="btnLogin" value="로그인">
</form>
<script>
// const fl = document.getElementById("frmLogin");
// fl.addEventListener('submit', ()=>{
// 	const el = document.getElementById("save_id_flag");
// 	if(el.checked){
// 		document.write("a")
// 		request.setAttribute("saveId", "Y"));
// 	} else{}
// })

// el.addEventListener('checked', () => {
// 	request.setAtrribute("saveId", "Y"));

// });
</script>
</body>
</html>