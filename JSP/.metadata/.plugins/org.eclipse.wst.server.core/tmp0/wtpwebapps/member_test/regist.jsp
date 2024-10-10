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

%>
<form action="regist_ok.jsp">
아이디 : <input type="text" name="id" value=""><br>
이름 : <input type="text" name="name" value=""><br>
비밀번호 : <input type="password" name="pwd" value=""><br>

<button type="submit">등록하기</button>
<button><a href="list.jsp">처음으로</a></button>
</form>
</body>
</html>