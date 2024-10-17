<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces = "true" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td {
	border : 1px solid skyblue; 
}
#pageList{
	display : flex;
	justify-content : space-around;
}
</style>
</head>
<body>
${id }님
<table>
	<tr>
		<td colspan="4">
			<form id="frmSearch" action="../bbs/list" method="GET">
				<select name="searchCategory">
					<option value=""></option>
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="memberId">아이디</option>
				</select>
				<input type="text" name="searchWord" value=""/>
				<input type="submit" value="검색"/>
			</form>
		</td>
		<td>
			<button onclick="deleteLink()">게시글삭제</button>	
		</td>
		<td>
			<button onclick="modifyLink()">게시글수정</button>
		</td>
		<td>
			<button onclick="logoutLink()">로그아웃</button>
		</td>
		<td colspan="2">
			<button onclick="registLink()">게시글등록</button>
		</td>
	</tr>
	
	<tr>
	<td>idx</td>
	<td>title</td>
	<td>memberId</td>
	<td>content</td>
	<td>regDate</td>
	<td>modifyDate</td>
	<td>readCnt</td>
	<td>삭제하기</td>
	<td>첨부</td>
	</tr>

	<c:set var="bbsList" value="${bbsList }" scope="session"/>
	<c:set var="i" value="0"/>
	
	<form action="../bbs/delete" id="frmList" method="POST" >
	<c:forEach var="bbsEl" items="${bbsList }">
		<tr>
			<td><a href="../bbs/view?idx=${bbsEl.idx}">${bbsEl.idx }</a></td>
			<td>${bbsEl.title }</td>
			<td>${bbsEl.memberId }</td>
			<td>${bbsEl.content }</td>
			<td>${bbsEl.regDate }</td>
			<td>${bbsEl.modifyDate }</td>
			<td>${bbsEl.readCnt }</td>
			<td><input type="checkbox" name="idx" id="deleteEl" value="${bbsEl.idx }"/></td>
			<td><c:if test="${!empty bbsEl.fileName }"><a href="../bbs/download?fileName=${bbsEl.fileName}">다운로드</a></c:if></td>
		</tr>
	</c:forEach>
	</form>
	<tr>   
		<td colspan="9" style="text-align : center;">
			<div id="pageList">
				<button id="prevBtn" onclick="moveBtn('prev')">prev</button>
				<div>
					<c:forEach var="page" begin="${startPage }" end="${lastPage }" step="1">
						<a href="../bbs/list?page=${page }&searchCategory=${searchCategory}&searchWord=${searchWord}">${page }</a>
					</c:forEach>
				</div>
				<button id="nextBtn" onclick="moveBtn('next')">next</button>
			</div>
		</td>
	</tr>
	

</table>
<script>
(function() {
    const frm = document.querySelector("#frmSearch");
    if (location.pathname.endsWith("list.jsp")) { // URL의 pathname을 확인
        frm.submit();
    }
})();
function deleteLink(){

	const frm = document.querySelector("#frmList");
	frm.submit();
}

function registLink(){
	location.href = "regist.jsp";
}

function logoutLink(){
    location.href = "../bbs/loginProc";
}

function moveBtn(move) {
	if(move == "prev"){
		location.href="?page=${startPage - 1}&searchCategory=${searchCategory}&searchWord=${searchWord}";
	}else{
		location.href="?page=${lastPage + 1}&searchCategory=${searchCategory}&searchWord=${searchWord}";
	}
}

const pBtn = document.querySelector("#prevBtn");
if(${startPage == 1}){
	pBtn.style.visibility = "hidden";
}
const nBtn = document.querySelector("#nextBtn");
if(${totalPages == lastPage}){
	nBtn.style.visibility = "hidden";
}

</script>


</body>
</html>