<%@page import="java.util.*"%>
<%@page import="fullstack7.member.MemberDAO"%>
<%@page import="fullstack7.member.MemberDTO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
String member_id = request.getParameter("member_id");
String name = request.getParameter("name");
int idx = Integer.parseInt(request.getParameter("idx"));
MemberDTO dto = new MemberDTO();
dto.setMemberId(member_id);
dto.setName(name);
dto.setPwd(pwd);

MemberDAO dao = new MemberDAO();
dao.setMemberModify(dto);
out.print("회원의 id가" + member_id +"인 회원의 정보가 수정되었습니다.");
// String sql = "UPDATE tbl_member SET name = ?, pwd = ? WHERE memberId = ? ";
// JDBConnect jdbc = new JDBConnect();
// PreparedStatement psmt = jdbc.con.prepareStatement(sql);
// psmt.setString(1, name);
// psmt.setString(2, pwd);
// psmt.setString(3, member_id);

// int inResult = psmt.executeUpdate();
// out.println("id가" + member_id + "인 행이 수정되었습니다.");
// jdbc.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button><a href="member_list1.jsp">처음으로</a></button>
</body>
</html>