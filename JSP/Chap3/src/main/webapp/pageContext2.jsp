<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@ page import = "dto.StudentDTO" %>
<%!
public static <T> boolean rtnCheck(Object param, T rtnType){
	return (param == null ? false : true);
// 	if(param == null || rtnType == null){	
// 		return false;
// 	}
// 	else return true;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// String nod="";
// if(pageContext.getAttribute("pageStNo") != null) {
// 	nod = (String)pageContext.getAttribute("pageStNo");
// }
// else {
// 	out.print("없음");
// }
// String named = "";
// if(pageContext.getAttribute("pageStName") != null) {
// 	named = (String)pageContext.getAttribute("pageStName");
// } 
// int aged = 0;
// if(pageContext.getAttribute("pageStAge") != null) {
// 	aged = (Integer)pageContext.getAttribute("pageStAge");
// }
// // String deptd = pageContext.getAttribute("pageStDept").toString();
// // int graded = (Integer)pageContext.getAttribute("pageStGrade");
// StudentDTO std2 = null;
// if(pageContext.getAttribute("pageStudent") != null) {
// 	std2 = (StudentDTO)pageContext.getAttribute("pageStudent");
// }


Object nod = pageContext.getAttribute("pageStNo");

Object named = "";
if(pageContext.getAttribute("pageStName") != null) {
	named = pageContext.getAttribute("pageStName");
} 
Object aged = 0;
if(pageContext.getAttribute("pageStAge") != null) {
	aged = pageContext.getAttribute("pageStAge");
}
// String deptd = pageContext.getAttribute("pageStDept").toString();
// int graded = (Integer)pageContext.getAttribute("pageStGrade");
Object std2 = null;
if(pageContext.getAttribute("pageStudent") != null) {
	std2 = pageContext.getAttribute("pageStudent");
}

%>
<ul>
	<li>rtnCheck : <%=(rtnCheck(nod, "int") ? nod : "null") %></li>
<%-- 	<%=rtnCheck(nod, "int") %> --%>
	<li><%=named %></li>
	<li><%=aged %></li>
<%-- 	<li><%=deptd %></li> --%>
<%-- 	<li><%=graded %></li> --%>
<%-- 	<li><%=std2.getDept() %> --%>
</ul>
</body>
</html>