<%@page import="net.fullstack7.bbs.BbsDTO"%>
<%@page import="java.util.List"%>
<%@page import="net.fullstack7.bbs.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
int idx = Integer.parseInt(request.getParameter(("idx")));
BbsDAO dao = new BbsDAO();
BbsDTO dto = dao.getBbsInfo(idx);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
dao.addReadCnt(idx);
%>
<h2>게시판 등록</h2>
<form name="frmView" id="frmView" method="post">
	<table>
	
		<tr>
			<th class="input_title">노출일</th>
			<th class="input_title"> 제목  </th>
			<th class="input_title">글내용</th>
		</tr>
	<tbody>
		<tr>
			<td></td>
			<td><%=dto.getTitle() %></td>
			<td><textarea><%=dto.getContent() %></textarea></td>
		
		</tr>
		<tr>
			<th colspan="4" class="align_center">
				<button><a href="modify.jsp?idx=<%=idx%>">수정</a></button>
				<button><a href="delete_ok.jsp">삭제</a></button>
				<button><a href="list.jsp">목록으로</a></button>
			</th>
		</tr>
	</tbody>
	</table>
</form>
<script>
	
</script>
</body>
</html>