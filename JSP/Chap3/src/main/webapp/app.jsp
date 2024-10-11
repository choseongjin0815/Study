<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="dto.StudentDTO" %>
<%
List<String> lists = new ArrayList<String>();
lists.add("사람A");
lists.add("사람B");
lists.add("사람C");
application.setAttribute("lists", lists);

Map<String, StudentDTO> maps = new HashMap<String, StudentDTO>();
maps.put("std1", new StudentDTO("20240101", "홍길순", 20, "화학공학과", 1));
maps.put("std2", new StudentDTO("20240102", "홍길동", 20, "기계공학과", 1));
application.setAttribute("maps", maps);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>application 영역 조회</h2>
<%
List<String> result_lists = (List<String>)application.getAttribute("lists");
Map<String, StudentDTO> result_maps = (Map<String, StudentDTO>)application.getAttribute("maps");

if(result_lists != null){
	for(String str : result_lists) {
		out.print("str : " + str + "<br>");
	}
}

if(result_maps != null){
	Set<String> keys = result_maps.keySet();
	for(String key :keys) {
		StudentDTO std = result_maps.get(key);
		out.print(String.format("학번 %s, 이름 %s, 나이 %d, 학과 %s, 학년 %d <br>",
				std.getNo(),
				std.getName(),
				std.getAge(),
				std.getDept(),
				std.getGrade()
				));
	}
}
%>
<br><br>
<a href="app2.jsp">application 페이지이동</a>
</body>
</html>