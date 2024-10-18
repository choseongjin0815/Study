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
	String str1 = "JSP";
	String str2 = "Hello~";
	String cstr = str1.concat(str2);
	String[] arr = new String[5];
%>



<h2 class = "headtitle"><%=str1 %>테스트 페이지 입니다.</h2>
<h3><%=cstr %>테스트</h3>

<p style="color : red">
	<%
	out.println(str2 + " " + str1);
	%>
</p>
<button class = "btn-window">naver</button>
<script>
	const arr = [1,2,3,4,5];
	for(i of arr) {
		document.write('<br>' + i);
		
			
	}

	const el = document.querySelector('.headtitle');
	const temp = el.style.color;
	el.addEventListener('mouseover', () => {
		el.style.color = "red";
	});
	el.addEventListener('mouseout', () => {
		el.style.color = temp;
	});
	
	const win = document.querySelector('.btn-window');
	win.addEventListener('click', () => {
		window.open("https://www.naver.com", '_blank');
	})
	
	
</script>
</body>
</html>