<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@page import ="dto.StudentDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>request 영역</h2>
<%
String reqType = request.getParameter("reqType");
%>
<%
request.setAttribute("req1", "request 영역");
// request.setAttribute("reqStudent", "request 영역");
request.setAttribute("reqStudent", new StudentDTO("20240102", "홍길순", 20, "화학공학과", 1));
%>

<h2>request 영역 속성값 조회</h2>
<%
Object req1 = request.getAttribute("req1");
Object reqStudent = request.getAttribute("reqStudent");
%>
<%
	StudentDTO std2 = null;
	if(reqStudent != null) {
		std2 = (StudentDTO)reqStudent;
	}
%>
<ul>
	<li><%=std2.getNo() %></li>
	<li><%=std2.getName() %></li>
	<li><%=std2.getAge() %></li>
	<li><%=std2.getDept() %></li>
	<li><%=std2.getGrade() %></li>
</ul>
<%
if (reqType!=null&&reqType.equalsIgnoreCase("send")) {
	response.sendRedirect("req2.jsp");
}
else if (reqType!=null&&reqType.equalsIgnoreCase("req")) {
// 	request.getRequestDispatcher("req2.jsp").forward(request, response);
	request.getRequestDispatcher("req2.jsp?user_id=user1&pwd=1234").forward(request, response);
}
//request.getRequestDispatcher("req2.jsp?user_id=user1&pwd=1234").forward(request, response);
%>
<br><a href="req2.jsp">페이지 이동시 소멸</a>
<br><a href="req.jsp?reqType=req">request forward</a>
<br><a href="req.jsp?reqType=send">response sendredirect</a>
</body>
</html>