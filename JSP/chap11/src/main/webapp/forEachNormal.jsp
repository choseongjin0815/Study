<%@page import="net.fullstack7.member.MemberDTO"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, tr, td{
		border:1px solid black
	}
</style>
</head>
<body>
<h4>일반 for문 형태의 forEach태그</h4>
<c:forEach var="i" begin="1" end="5" step="1">
	${i*2}<br>
</c:forEach>

<h3>varStatus 속성 값 조회</h3>
<table>
	<tr>
		<td>count</td>
		<td>index</td>
		<td>current</td>
		<td>first</td>
		<td>last</td>
	</tr>
	<c:forEach var="i" begin="1" end="10" varStatus="loopStatus">
	<tr>
		<td>${loopStatus.count }</td>
		<td>${loopStatus.index }</td>
		<td>${loopStatus.current }</td>
		<td>${loopStatus.first }</td>
		<td>${loopStatus.last }</td>
	</tr>
	</c:forEach>
	<tr>
		<td>count</td>
		<td>index</td>
		<td>current</td>
		<td>first</td>
		<td>last</td>
	</tr>
</table>
<h3>1~100까지의 합</h3>

<c:forEach var="i" begin="1" end="100">
<c:if test="${i mod 2 eq 0 }" >
<c:set var="evenTotal" value="${evenTotal + i }"/>
</c:if>
</c:forEach>
${evenTotal }

<h3>Array</h3>
<%
String[] arrStr = {"축구", "야구", "농구", "족구"};
%>

<c:forEach var="str" items="<%=arrStr%>">
	<span>구기종목 : ${str }</span>
</c:forEach>
</body>

<h3>List 컬렉션</h3>
<%
List<MemberDTO> dtoList = new ArrayList<MemberDTO>();
dtoList.add(new MemberDTO("user1", "홍길동", "남성"));
dtoList.add(new MemberDTO("user2", "홍길순", "여성"));
dtoList.add(new MemberDTO("user3", "홍길만", "남성"));
%>
<c:set var="dto" value="<%=dtoList %>"/>
<ul>
<c:forEach var="list" items="${dto }">
	<li>아이디 : ${list.memberId }</li>
	<li>이름 : ${list.name }</li>
	<li>성별 : ${list.gender }</li>
</c:forEach>
</ul>

<h3>Map 컬렉션</h3>
<%
Map<String, MemberDTO> maps = new LinkedHashMap<String, MemberDTO>();
maps.put("member1" , new MemberDTO("user1", "홍길동", "남성"));
maps.put("member2" , new MemberDTO("user2", "홍길순", "여성"));
maps.put("member3" , new MemberDTO("user3", "홍길만", "남성"));
%>
<c:set var="dtoMaps" value="<%=maps %>"/>
<ul>
	<c:forEach items="${dtoMaps }" var="map">
	<li>key : ${map.key }</li>
	<li>아이디 : ${map.value.memberId }</li>
	<li>이름 : ${map.value.name }</li>
	<li>성별 : ${map.value.getGender() }</li>
	<br>
	
	</c:forEach>
</ul>
</html>