<%@page import="fullstack7.member.MemberDAO"%>
<%@page import="fullstack7.member.MemberDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.DBConnPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("login_id");
String pwd = request.getParameter("login_pwd");
String flag = request.getParameter("auto_id_flag");

%>

<%



// String sql = "SELECT memberId, pwd FROM tbl_member WHERE memberId = ? AND pwd = ?";
// DBConnPool dbcp = new DBConnPool();
// PreparedStatement psmt = dbcp.con.prepareStatement(sql);
// psmt.setString(1, id);
// psmt.setString(2, pwd);
// ResultSet rs = psmt.executeQuery();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
// MemberDTO memberDTO = new MemberDTO();
// memberDTO.setMemberId(id);
// memberDTO.setName("이름");

// memberDTO.setPwd(pwd);
String dBDriver = application.getInitParameter("MariaDriver");
String dBUrl = application.getInitParameter("MariaURL");
String dBId = application.getInitParameter("dbId");
String dBPwd = application.getInitParameter("dbPwd");
MemberDAO dao = new MemberDAO(dBDriver, dBUrl, dBId, dBPwd);
MemberDTO dto = dao.getMemberInfo(id, pwd);
dto.setFlag(flag);

if(dto != null && dto.getMemberId() != null) {
			
			session.setAttribute("mid", dto.getMemberId());
			session.setAttribute("mpwd", dto.getPwd());
			if(dto.getFlag() != null && dto.getFlag().equals("Y")){
				session.setAttribute("mflag", dto.getFlag());
			}
		}
else{
			out.print(session.getAttribute("mid"));
			out.print("로그인 실패");
}
	


response.sendRedirect("bbs_main.jsp");

%>
</body>
</html>