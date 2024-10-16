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
<c:set var="t1">
	i태그 <i>이탤릭체</i>로 출력합니다.
</c:set>

<h3>기본 형태</h3>
<c:out value="${t1 }"/>

<h3>escapeXml</h3>
<c:out value="${t1 }" escapeXml="false"/>

<h3>default 속성값</h3>
<c:out value="${param.name }" default="이름값없음"/>

</body>
</html>