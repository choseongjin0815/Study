<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.DBConnPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sql = "SELECT memberId, name, pwd FROM tbl_member";
DBConnPool dbcp = new DBConnPool();
PreparedStatement psmt = dbcp.con.prepareStatement(sql);
ResultSet rs = psmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
while(rs.next()){
	out.print(rs.getString(1) +" ");
	out.print(rs.getString(2) +" ");
	out.print(rs.getString(3) +" ");
	out.print("<br>");	
}
dbcp.close();
%>
</body>
</html>