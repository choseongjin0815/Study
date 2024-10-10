<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String flag_check = (String)session.getAttribute("mflag");
if(flag_check == null){
	session.removeAttribute("mid");
	session.removeAttribute("mpwd");
}
else{
	session.removeAttribute("mpwd");
}
response.sendRedirect("bbs_main.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>