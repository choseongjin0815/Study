<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%
String popupMode = "on";

Cookie[] cookies = request.getCookies();
if(cookies != null) {
	for(Cookie c : cookies) {
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		if(cookieName.equals("popupClose")){
			popupMode = cookieValue;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./JS/jquery3.7.1.min.js"></script>
<style>
	div#divPop1 {
		width:300px;
		height:100px;
		background-color: yellow;
	}
	div#divPop1>div{
		margin-top:80px;
	}
</style>
</head>
<body>
<h2>팝업창 페이지</h2>

<script>
// 	$(function() {
// 		$("#btnClose").click(function(){
// 			$("#divPop1").hide();
// 			var chkVal = $("input:checkbox[id=popflag]:checked").val();
// 			if(popflag =="Y") {
// 				$.ajax({
// 					url : "./set_popup_cookie.jsp",
// 					type: "get",
// 					data : {popflag : chkVal},
// 					dataType : "text",
// 					success : function(data) {
// 						if(data != '') location.reload();
						
// 					},
// 					error:function(request, status, error) {
// 						console.log()
// 					}
// 				});
// 			}
// 		});
// 	});
</script>

<script>
const el = document.getElementById("#popflag");
el.addEventListener('change', ()=>{
	if(this.checked) {
		input.value="N";
	}
	else {
		input.value = "Y";
	}
})
</script>
<%
for(int i = 1; i <= 10; i++){
	out.print("현재 팝업창은 "+popupMode + "상태입니다.<br>");
}
if(popupMode.equals("on")){
%>
	<div id="divPop1">
	<h2 align="center">공지사항 팝업</h2>
	<div align="right">
		<form name="frmPop1" id="frmPop1" action="set_popup_cookie.jsp">
			<input type="checkbox" id="popflag" name="popflag" value="Y">하루 동안 창 열지 않음
			<input type="button" id="btnClose" name="btnClose" value="닫기">	
			<input type="submit" value="제출">
		</form>
	</div>
</div>
<%

}
%>
</body>
</html>