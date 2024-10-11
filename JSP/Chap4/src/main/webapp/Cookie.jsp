<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%!
public void setCookie(String name, String value, int time, HttpServletRequest request, HttpServletResponse response) {
	Cookie cookies = new Cookie(name, value);
	cookies.setMaxAge(time);
	cookies.setPath(request.getContextPath());
	cookies.setMaxAge(3600);
	response.addCookie(cookies);
}

public String[][] getCookie(Cookie[] cookies) {
	String[][] cookieNV = new String[2][cookies.length];
	if (cookies != null) {
		for(int i = 0; i < cookies.length; i++) {
			cookieNV[0][i] = cookies[i].getName();
			cookieNV[1][i] = cookies[i].getValue();
			
		}

	}
	return cookieNV;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1.쿠키 설정</h2>
<%

// setCookie(cookie.setPath(request.getContextPath(), response.addCookie(cookie));
setCookie("cookie1", "쿠키값1", 3600, request, response);


setCookie("cookie2", "쿠키값2", 3600, request, response);

// Cookie cookie = new Cookie("cookie1", "쿠키값1");
// cookie.setPath(request.getContextPath());
// cookie.setMaxAge(3600);
// response.addCookie(cookie);
%>
<h2>2. 쿠키값 확인</h2>
<%
Cookie[] cookies = request.getCookies(); //요청 헤더에 있는 모든 쿠키 조회
// if (cookies != null) {
// 	for(Cookie c : cookies) {
// 		String cookieName = c.getName();
// 		String cookieValue = c.getValue();
// 		out.print(String.format("%s : %s<br>", cookieName, cookieValue));
// 	}
// }
String[][] cookieNameValue = getCookie(cookies);

for(int i = 0; i < cookieNameValue[0].length; i++){
	out.print(String.format("cookie name : %s , cookie value : %s<br>", cookieNameValue[0][i], cookieNameValue[1][i]));
}
%>
<h2>3.페이지 이동 후 쿠키(cookie)값 확인</h2>
<a href="Cookie2.jsp">페이지이동</a>
</body>
</html>