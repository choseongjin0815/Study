<%@page import="java.util.*"%>
<%@page import="net.fullstack7.member.MemberDTO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>list 컬렉션 사용</h3>
<%
ArrayList<MemberDTO> mList = new ArrayList<MemberDTO>();
mList.add(new MemberDTO("user1", "홍길동", "남성"));
mList.add(new MemberDTO("user2", "홍길순", "여성"));
%>
<c:set var="personList" value="<%=mList %>" scope="request"/>
<ul>
	<li>아이디: ${requestScope.personList[0].memberId }</li>
	<li>이름: ${requestScope.personList[0].name }</li>
	<li>성별: ${requestScope.personList[0].gender }</li>
</ul>
<h3>map 사용</h3>
<%
Map<String, MemberDTO> map = new HashMap<String, MemberDTO>();
map.put("member1", new MemberDTO("user1", "홍길동", "남성"));
map.put("member2", new MemberDTO("user2", "홍길순", "여성"));
%>
<c:set var="map1" value="<%=map %>" scope="request"/>
<ul>
	<li>아이디 : ${requestScope.map1.member1.memberId }</li>
	<li>이름 : ${requestScope.map1.member1.name }</li>
	<li>성별 : ${requestScope.map1.member1.gender }</li>
	<li>아이디 : ${requestScope.map1.member2.memberId }</li>
	<li>이름 : ${requestScope.map1.member2.name }</li>
	<li>성별 : ${requestScope.map1.member2.gender }</li>
</ul>
</body>
</html>