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
<h2>서블릿의 생명주기 테스트</h2>
<form name="frmRequest" id="frmRequest" action="./Life.do">
	<input type="button" name="btnGet" id="btnGet" value="Get방식요청" onclick="reqAction(this.form, 1)"/>
	<input type="button" name="btnPost" id="btnPost" value="Post방식요청" onclick="reqAction(this.form, 2)"/>
</form>
</body>

<script>
function reqAction(frm, type) {
	const frmReq = document.getElementById("frmRequest");
	if(type==1) {
		frmReq.method = "GET";
	} else {
		frmReq.method = "POST";
	}
	
	frm.submit();
}
</script>
</html>