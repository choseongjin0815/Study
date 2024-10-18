<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@page import="common.JDBConnect"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String pwd = request.getParameter("pwd");

String sql = "INSERT INTO tbl_member(`memberId`, `name`, `pwd`) VALUES(?, ?, ?)";
JDBConnect jdbc = new JDBConnect();
PreparedStatement psmt = jdbc.con.prepareStatement(sql);
psmt.setString(1, id);
psmt.setString(2, name);
psmt.setString(3, pwd);
int inResult = psmt.executeUpdate();
jdbc.close();
%>
<%
out.print("ID : " + id + "name : " + name + "password : " + pwd + "인 데이터 추가완료");
%>


<button><a href="list.jsp">처음으로</a></button>
</body>
</html>