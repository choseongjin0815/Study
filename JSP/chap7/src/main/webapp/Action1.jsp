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
<h2>include 액션 태그</h2>

<h3>include 지시어로 포함</h3>
<%@ include file="includeDirective.jsp" %>
<%
String param1 = "parent에서 선언";
%>
<h3>include 액션 태그로 포함</h3>
<%
String pageUrl1 = "includeActAction2.jsp";
pageContext.setAttribute("param1", "pageConparam1");
request.setAttribute("param2", "requestparam2");
%>

<p>지시어 자식 페이지에서 선언한 변수 : <%=param2 %>
<br>
<hr>
<br>
<jsp:include page="includeActAction2.jsp"/>
	<jsp:param name="param3" value="부모창에서 보낸 파라미터 3"/>
</jsp:include>
<jsp:include page="<%=pageUrl1 %>"/>
<p>액션태그 자식 페이지에서 선언한 변수 : <%=param2 %>
<%-- <p>액션태그 자식 페이지에서 선언한 변수 : <%=param2 %> --%>
</body>
</html>