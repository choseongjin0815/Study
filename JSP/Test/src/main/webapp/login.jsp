<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String idValue = "";
	String flagValue = "";
	String check ="";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie c : cookies){
			String cookieName = c.getName();
			String cookieValue = c.getValue();
			
			if(cookieName.equals("ID")){
				idValue = cookieValue;
			}
			
			if(cookieName.equals("flag")){
				flagValue = cookieValue;
				if(flagValue.equals("Y")){
					check = "checked";
				}
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
<form action="login_ok.jsp" method="post">
	<label for="id">id : </label>
	<input type="text" id="id" name="id" value="<%=idValue %>">
	<input type="checkbox" id="save_id_check" name="save_id_check" value="Y" <%=check %>>ID저장
	<br>
	<label for="pwd">password : </label>
	<input type="password" id="pwd" name="pwd" value="">
	<input type="submit" value="로그인">
</form>
</body>
</html> 