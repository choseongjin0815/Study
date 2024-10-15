<%@page import="net.fullstack7.bbs.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
String[] strIdxs = request.getParameterValues("bbs_idx");


try {
	Integer[] idxs = new Integer[strIdxs.length];
    for (int i = 0; i < strIdxs.length; i++) {
    	out.print(i);
        idxs[i] = Integer.parseInt(strIdxs[i]);
        BbsDAO dao = new BbsDAO();
        dao.setDeleteBbs(idxs);
    }
} catch (NumberFormatException e) {
    e.printStackTrace();
}
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