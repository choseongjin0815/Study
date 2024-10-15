<%@page import="net.fullstack7.bbs.BbsDAO"%>
<%@page import="net.fullstack7.bbs.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
int idx = Integer.parseInt(request.getParameter("idx"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 등록</h2>
<form name="frmRegist" action="modify_ok.jsp" method="get">
<table>

<tr>
	<th class="input_title">인덱스</th>
	<th class="input_title"> 제목 </th>
	<th class="input_title"> 내용 </th>
</tr>
<tr>
	<td><input type="text" name="idx" value="<%=idx %>" readonly></td>
	<td><input type="text" name="title" value=""></td>
	<td><input type="textarea" name="content" value=""></td>
</tr>
</table>
<button type="submit">수정하기</button>
</form>
</body>
</html>
</body>
</html>