<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>

<%
List<String> lists = new ArrayList<String>();
lists.add("사람A");
lists.add("사람B");
lists.add("사람C");
session.setAttribute("lists", lists);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>session 영역</h2>

<%
List<String> lists2 = (List<String>)session.getAttribute("lists"); //여기 들어오는 값이 null이면 안됨, set이나 remove는 없어도 동작 그러나 get은 무언가 있어야함.
if(lists != null){
	for(String str : lists2) {
		out.print("str : " + str + "<br>");
	}
}
%>
<br>
<a href="session2.jsp">페이지 이동후 session 영역 조회</a>
</body>
</html>