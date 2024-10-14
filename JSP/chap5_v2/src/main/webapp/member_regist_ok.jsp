<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
String member_id = request.getParameter("member_id");
String name = request.getParameter("name");
String pwd = request.getParameter("pwd");


//history.back()자바스크립트
// if(member_id.length() < 4 || member_id.length() > 20 ) {
// 	alert("아이디를 4자리 이상 20자리 이하로 입력하세요.");
// 	frm.member_id.focus();
// 	return;
// }

// if(memberName.length < 4 || name.length > 20 ) {
// 	alert("이름을 4자리 이상 20자리 이하로 입력하세요.");
// 	frm.memberName.focus();
// 	return;
// }

// if(pwd.length < 4 || pwd.length > 20 ) {
// 	alert("비밀번호를 4자리 이상 20자리 이하로 입력하세요.");
// 	frm.pwd.focus();
// 	return;
// }

%>

<%
String sql = "INSERT INTO tbl_member(memberId, name, pwd) VALUES(?,?,?)";
JDBConnect jdbc = new JDBConnect();
PreparedStatement psmt = jdbc.con.prepareStatement(sql);
psmt.setString(1, member_id);
psmt.setString(2, name);
psmt.setString(3, pwd);

int inResult = psmt.executeUpdate();
out.println(inResult + "행이 입력되었습니다.");
jdbc.close();
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