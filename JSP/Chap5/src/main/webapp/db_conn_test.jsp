<%@page import="common.DBCoonPool"%>
<%@page import="common.JDBConnect"%>
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
<h2>JDBC 테스트1</h2>
<%
	JDBConnect jdbc1;
try{
	jdbc1 = new JDBConnect();
	out.println("=================================<br>");
	out.println("DB 접속 성공(기본생성자)<br>");
	out.println("jdbc1" + jdbc1 + "<br>");
	out.println("=================================<br>");
} catch(Exception e) {
	out.println("=================================<br>");
	out.println("DB 접속 에러(기본생성자)<br>");
	out.println(e.getMessage());
	out.println("=================================<br>");
}
	
%>
<h2>JDBC 테스트2</h2>
<%
	String dbType = "Maria";
	String driver = application.getInitParameter(dbType + "Driver");
	String url = application.getInitParameter("MariaURL");
	String id = application.getInitParameter("dbId");
	String pwd = application.getInitParameter("dbPwd");

	JDBConnect jdbc2;
try{
	jdbc2 = new JDBConnect(driver, url, id, pwd);
	out.println("=================================<br>");
	out.println("DB 접속 성공(사용자정의생성자)<br>");
	out.println("jdbc2" + jdbc2 + "<br>");
	out.println("=================================<br>");
	jdbc2.close();
} catch(Exception e) {
	out.println("=================================<br>");
	out.println("DB 접속 에러(사용자정의생성자)<br>");
	out.println(e.getMessage());
	out.println("=================================<br>");
} 
	
%>

<h2>JDBC 테스트3</h2>
<%

	JDBConnect jdbc3;
try{
	jdbc3 = new JDBConnect(application);
	out.println("=================================<br>");
	out.println("DB 접속 성공(사용자정의생성자)<br>");
	out.println("jdbc3" + jdbc3 + "<br>");
	out.println("=================================<br>");
} catch(Exception e) {
	out.println("=================================<br>");
	out.println("DB 접속 에러(사용자정의생성자)<br>");
	out.println(e.getMessage());
	out.println("=================================<br>");
}
	
%>

<h2>커넥션풀 테스트</h2>
<%

	

try{
	DBCoonPool pool = new DBCoonPool();
	out.println("=================================<br>");
	out.println("DB 접속 성공(사용자정의생성자)<br>");
	out.println("pool" + pool + "<br>");
	out.println("=================================<br>");
	pool.close();
} catch(Exception e) {
	out.println("=================================<br>");
	out.println("DB 접속 에러(사용자정의생성자)<br>");
	out.println(e.getMessage());
	out.println("=================================<br>");
}
	
%>
</body>
</html>