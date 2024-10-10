<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ page import="dto.StudentDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>page 영역 속성값 처리</h2>
<%
pageContext.setAttribute("pageStNo", "20240101");
pageContext.setAttribute("pageStName", "홍길동");
pageContext.setAttribute("pageStAge", 20);
pageContext.setAttribute("pageStDept", "전자공학");
pageContext.setAttribute("pageStGrade", 1);
pageContext.setAttribute("pageStudent", new StudentDTO("20240102", "홍길순", 20, "화학공학과", 1));
%>

<%
String no = (String)pageContext.getAttribute("pageStNo"); //혹은. toString()
String name = (String)pageContext.getAttribute("pageStName");
int age = (Integer)pageContext.getAttribute("pageStAge");
String dept = pageContext.getAttribute("pageStDept").toString();
int grade = (Integer)pageContext.getAttribute("pageStGrade");
StudentDTO pageStd = (StudentDTO)pageContext.getAttribute("pageStudent");
%>
object = <%=pageStd.getName() %>
<h2>include된 파일에서 page 영역 읽어오기</h2>
<!-- <form action="page_test.jsp"> -->
<!-- <input type="text" name="ggg" value=""> -->
<!-- <input type="submit" value = "submitt"> -->
<!-- </form> -->
<%@ include file="page_include.jsp" %>
<h2>페이지 이동 후 page 영역 값 조회</h2>
<a href="pageContext2.jsp">이동</a>


</body>
</html>