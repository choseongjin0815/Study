<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
String id = request.getParameter("id");
String sql = "SELECT memberId, name, pwd FROM tbl_member WHERE memberId = ?";
JDBConnect jdbc = new JDBConnect();
PreparedStatement psmt = jdbc.con.prepareStatement(sql);
psmt.setString(1, id);
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
while(rs.next()) {
%>
id : <%=rs.getString(1)%><br>
name : <%=rs.getString(2)%><br>
pwd : <%=rs.getString(3)%><br>
<% 
}
%>
</body>
</html>