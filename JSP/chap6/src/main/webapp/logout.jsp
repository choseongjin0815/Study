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

String chkVal = (String)session.getAttribute("save_id_flag");
String idInfo = (String)session.getAttribute("memberId");
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
	
	session.setAttribute("memberId", "");
	session.setAttribute("savaId", dbId);
	if(chkVal!=null && chkVal.equals("Y")) {
		session.setAttribute("save_id_flag", chkVal);
	}


response.sendRedirect("Login.jsp");
%>
<button><a href="Login.jsp">처음으로</a></button>
</body>
</html>