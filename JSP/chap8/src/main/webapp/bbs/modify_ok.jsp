<%@page import="net.fullstack7.bbs.BbsDAO"%>
<%@page import="net.fullstack7.bbs.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
int idx = Integer.parseInt(request.getParameter("idx"));
String title = request.getParameter("title");
String content = request.getParameter("content");

BbsDTO dto = new BbsDTO();
dto.setTitle(title);
dto.setContent(content);
dto.setIdx(idx);

BbsDAO dao = new BbsDAO();
dao.setMemberModify(dto);

response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 등록</h2>
</body>
</html>