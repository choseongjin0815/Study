<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%

String chkVal = request.getParameter("popflag");
if(chkVal != null && chkVal == "Y") {
	Cookie cookie = new Cookie("popupClose", "off");
	cookie.setPath(request.getContextPath());
	cookie.setMaxAge(3600);
	response.addCookie(cookie);
	out.print("하루동안 열지 않음");
	
}

response.sendRedirect("popup.jsp");
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