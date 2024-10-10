<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
public void setCookieId(String id, int second, HttpServletRequest request, HttpServletResponse response){
	Cookie cookie = new Cookie("ID", id);
	cookie.setPath(request.getContextPath());
	cookie.setMaxAge(second);
	response.addCookie(cookie);
}

public void setCookieAutoFlag(String flag, int second, HttpServletRequest request, HttpServletResponse response){
	Cookie cookie = new Cookie("flag", flag);
	cookie.setPath(request.getContextPath());
	cookie.setMaxAge(second);
	response.addCookie(cookie);
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
String id = request.getParameter("id");
String auto_check = request.getParameter("save_id_check");
if(auto_check != null && auto_check.equals("Y")){
	setCookieId(id, 3600, request, response);
	setCookieAutoFlag(auto_check, 3600, request, response);
}
else{
	setCookieId("", 10, request, response);
	setCookieAutoFlag("", 10, request, response);
}

response.sendRedirect("login.jsp");
%>

</body>
</html>