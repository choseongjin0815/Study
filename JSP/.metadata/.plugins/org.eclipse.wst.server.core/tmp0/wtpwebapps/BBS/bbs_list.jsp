<%@page import="fullstack7.member.MemberDTO"%>
<%@page import="fullstack7.member.MemberDAO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String dBDriver = application.getInitParameter("MariaDriver");
String dBUrl = application.getInitParameter("MariaURL");
String dBId = application.getInitParameter("dbId");
String dBPwd = application.getInitParameter("dbPwd");
MemberDAO dao = new MemberDAO(dBDriver, dBUrl, dBId, dBPwd);
List<MemberDTO> dto = dao.getMemberList();
if(dto != null) {
	for(MemberDTO m : dto) {
		out.println(m.getMemberId() + " " + m.getName() + " " + m.getPwd() +"<br>");
	}
}else {
	out.print("회원 정보가 하나도 없습니다.");
}

%>

</body>
</html>