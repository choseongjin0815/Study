<%@page import="common.JDBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
JDBConnect jdbc = new JDBConnect();
String sql ="SELECT memberId, name, pwd FROM tbl_member;";
PreparedStatement psmt = jdbc.con.prepareStatement(sql);

ResultSet rs = psmt.executeQuery();
%>
<table border="1px">
<%
while(rs.next()) {
%>
<tr class="table">
<td><a href="view.jsp?id=<%=rs.getString(1) %>"><%=rs.getString(1) %><a></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
</tr>
<br>
<%
}
%>
</table>
<button><a href="regist.jsp">등록페이지로 이동합니다.</a></button>
</body>
</html>