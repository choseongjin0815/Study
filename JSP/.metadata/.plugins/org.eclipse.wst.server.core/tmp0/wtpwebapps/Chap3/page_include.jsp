<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ page import="dto.StudentDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
li{
	list-style : none;
}
</style>
</head>
<body>
<%
String nod = (String)pageContext.getAttribute("pageStNo"); //혹은. toString()
String named = (String)pageContext.getAttribute("pageStName");
int aged = (Integer)pageContext.getAttribute("pageStAge");
String deptd = pageContext.getAttribute("pageStDept").toString();
int graded = (Integer)pageContext.getAttribute("pageStGrade");
StudentDTO std2 = (StudentDTO)pageContext.getAttribute("pageStudent");
%>
<ul>
	<li><%=nod %></li>
	<li><%=named %></li>
	<li><%=aged %></li>
	<li><%=deptd %></li>
	<li><%=graded %></li>
	<li><%=std2.getDept() %>
</ul>


<p>

</p>
</body>
</html>