<%@page import="net.fullstack7.bbs.BbsDTO"%>
<%@page import="java.util.List"%>
<%@page import="net.fullstack7.bbs.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
BbsDAO dao = new BbsDAO();
List<BbsDTO> dto = dao.getBbsList();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 목록</h2>
<table>
		<tr style="background-color : grey">
			<th>선택</th>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
			<th>삭제</th>
		</tr>
	
	<tbody>
	<form id="frmList" action="delete_ok.jsp">
		<%
		for(BbsDTO bbsEl : dto) {
		%>
		<tr>
			<td><input type="checkbox" id="bbs_idx" name="bbs_idx" value="<%=bbsEl.getIdx()%>"/> </td>
			<td><%=bbsEl.getIdx() %></td>
			<td><a id="readBbsEl" href="view.jsp?idx=<%=bbsEl.getIdx()%>"><%=bbsEl.getTitle()%></a> </td>
			<td><%=bbsEl.getMemberId()%></td>
			<td><%=bbsEl.getReadCnt() %> </td>
			<td><%=bbsEl.getRegDate()%></td>
			<td>삭제</td>
			
		</tr>
		<%
		}
		%>
		<tr>
			<td colspan="7">등록된 게시물이 존재하지 않습니다.</td>
		</tr>
		<tr>
			<td colspan="7"> <<1 | 2 | 3>> </td>
		</tr>
		<tr>
			<td colspan="7"> 
				<input type="submit" id="btnRegist" name="btnRegist" value="등록">
				<button onclick="frmDelete()">삭제</button>
			</td>
		</tr>
	</form>
</table>
<script>
function frmDelete(e) {
	e.preventDefault();
	const frmL = document.querySelector("#frmList");
	frmL.action = "delete_ok.jsp";
	frmL.submit();
}
</script>
</body>
</html>