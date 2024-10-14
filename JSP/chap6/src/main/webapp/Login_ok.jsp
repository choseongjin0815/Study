<%@page import="common.DBCoonPool"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="common.JDBConnect"%>
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
String sql ="SELECT memberId, pwd FROM tbl_member WHERE memberId = ?";
DBCoonPool dbcp = new DBCoonPool();
PreparedStatement psmt = dbcp.con.prepareStatement(sql);
psmt.setString(1, idInfo);

ResultSet rs = psmt.executeQuery();
String dbId = "";
while(rs.next()){
	dbId = rs.getString(1);
}
out.print(dbId);
// out.print(chkVal + "<br>");
if(chkVal!=null && chkVal.equals("Y")) {
	if(dbId.equals(idInfo)){
		session.setAttribute("memberId", dbId);
		session.setAttribute("save_id_flag", chkVal);
	}
	else{
%>
<script>
alert('아이디가 틀립니다.');
</script>
<% 	
	}
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


response.sendRedirect("Login.jsp");
dbcp.close();
%>
</body>
</html>