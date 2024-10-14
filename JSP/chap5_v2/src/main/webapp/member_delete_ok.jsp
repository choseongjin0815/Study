<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
String memName = request.getParameter("name");

String sql = "DELETE FROM tbl_member WHERE name = ?";
JDBConnect jdbc = new JDBConnect();
PreparedStatement pstm = jdbc.con.prepareStatement(sql);
pstm.setString(1, memName);
int inResult = pstm.executeUpdate();
out.print("이름이 " + memName + "인 회원의 정보가 삭제되었습니다.");
jdbc.close();

//ResultSet rs = pstm.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button><a href="member_list1.jsp" style="text-decoration:none">처음으로</a></button>
</body>
</html>