<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String chkVal = request.getParameter("save_id_flag");
String idInfo = request.getParameter("memberId");
String sql ="SELECT memberId FROM tbl_member WHERE memberId = ?";
JDBConnect jdbc = new JDBConnect();
PreparedStatement psmt = jdbc.con.prepareStatement();
psmt.setString(1, idInfo);
// out.print(chkVal + "<br>");
if(chkVal!=null && chkVal.equals("Y")) {
	
// 	Cookie cookie = new Cookie("autoId", idInfo);
// 	Cookie loginflag = new Cookie("loginflag", "checked");
// 	cookie.setPath(request.getContextPath());
// 	cookie.setMaxAge(10);
// 	response.addCookie(cookie);
// 	loginflag.setPath(request.getContextPath());
// 	loginflag.setMaxAge(3600);
// 	response.addCookie(loginflag);
// // 	out.print("test");
}else{
// 	Cookie cookie = new Cookie("autoId", "");
// 	cookie.setPath(request.getContextPath());
// 	cookie.setMaxAge(10);
// 	response.addCookie(cookie);
// 	Cookie loginflag = new Cookie("loginflag", "");
// 	loginflag.setPath(request.getContextPath());
// 	loginflag.setMaxAge(3600);
// 	response.addCookie(loginflag);
}

session.setAttribute("memberId", idInfo);
session.setAttribute("name", "");

response.sendRedirect("Login.jsp");
%>
</body>
</html>