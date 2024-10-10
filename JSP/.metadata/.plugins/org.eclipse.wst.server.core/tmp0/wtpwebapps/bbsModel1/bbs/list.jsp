<%@page import="common.PageUtil"%>
<%@page import="model1.bbs.BbsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ include file="/common/header.jsp" %>
<%@ include file="/common/queryString.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<style>
	* {margin : 0; padding : 0;}
	body {
		width : 100%;
		margin : 0 auto;
	}
	main {
		width : 1000px;
		margin : 0 auto;
	}
	h2 {
		padding : 20px;
		text-align : center;
	}
	table, tr, td, th {
		border-collapse:collapse;
		padding : 10px;
	}
	table {
		width : 100%;
		margin : 10px 0;
	}
	.border, .border tr, border th {
		border: 1px solid #aaa;		
	}
	.border td:nth-child(1), td:nth-child(3), td:nth-child(4), td:nth-child(5){
		text-align : center;
	}
	.search_area {
		border : 1px solid #aaa;
		background : #eee;
		text-align : center;
		height : 80px;
	}
	th {
		background : #e3f0ff;
	}
	input, select {
		box-sizing : border-box;
		height : 30px;
	}
	#search_word {
		width : 200px;
	}
	input[type = "button"], input[type = "submit"] {
		background : #e3f0ff;
		border : 1px solid #aaa;
		padding : 5px 10px;
	}
	a, a:link, a:hover, a:active, a:visited {
		color : #000;
		text-decoration : none;
	}
	a:hover {
		text-decoration : underline !important;
	}
	.pageArea {
		text-align : center;
		padding : 10px 0;
	}
	span {width : 30px; display : inline-block;}
	
	a.selected {
		color : blue;
		text-decoration : underline;
	}
</style>
</head>
<body>
<%
// 게시글 조회 부분
// 게시글 조회를 위한 Map객체 생성 (검색영역, 검색어, 현재 페이지)
Map<String, Object> param = new HashMap<String, Object>();
param.put("search_category", search_category);
param.put("search_word", search_word);
param.put("page_selected", page_selected);

// 게시글 조회
BbsDAO dao = new BbsDAO(application);
List<BbsDTO> bbsList = dao.bbsPagingList(param);

//총 게시글 수 조회
int total_count = dao.bbsTotalCount(param);
dao.close();

//게시글 html 생성
String boardList = PageUtil.makeList(bbsList, total_count, page_selected, queryStringPCW);

// 페이징 관련 부분
//총페이지 개수 계산
int total_page = (int) Math.ceil((double)total_count / 10);

// 페이징 html 코드 만들어내기
String pageList = PageUtil.makeMageNumber(total_page, 10, page_selected, queryStringCW);

%>
<main>
	<h2><a href="list.jsp">게시판 목록</a></h2>
	<input type="button" name="register" id="register" value="게시글 작성">
	<table class="search_area">
	 <tr>	
		<td>
			<form id="frmSearch" method="get">
				<select name="search_category" id="search_category">
					<option value="" <%= (search_category.equals("") ? "selected" : "")  %>>선택</option>
					<option value="title" <%= (search_category.equals("title") ? "selected" : "")  %>>제목</option>
					<option value="content" <%= (search_category.equals("content") ? "selected" : "")  %>>글내용</option>
					<option value="user_id" <%= (search_category.equals("user_id") ? "selected" : "")  %>>작성자</option>
				</select>
				<input type="text" name="search_word" id="search_word" value="<%= search_word %>" maxlength="100">
				<input type="submit" name="btn_search" id="btn_search" value="검색하기">
			</form>
		</td>
	</tr>
	</table>
	<table class="border">
		<caption style="display:none">표제목</caption>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
 		<tbody>
			<%= boardList %>
		</tbody>
	</table>
	<div class="pageArea">
		<%= pageList %>
	</div>
</main>
<script>
// 등록페이지로 가기 이벤트
const register = document.querySelector("#register");
register.addEventListener("click", (e)=> {
	location.href = "register.jsp?<%=queryStringPCW%>"
})

// 검색 값 유효성 체크
const frmSearch = document.querySelector("#frmSearch");
frmSearch.addEventListener("submit", (e)=>{
	e.preventDefault();
	let search_category = document.querySelector("#search_category").value;
	if(search_category == null || search_category == "") {
		document.querySelector("#search_category").focus();
		return alert("검색조건을 선택해주세요.");
	}
	
	let search_word = document.querySelector("#search_word").value;
	if (search_word == null) {
		document.querySelector("#search_word").focus();
		return alert("검색어를 입력해주세요.")
	} else {
		search_word = search_word.trim();
		if(search_word == "") {
			document.querySelector("#search_word").focus();
			return alert("검색어를 한 글자 이상 입력해주세요.");
		}
	} 
	frmSearch.submit();
})

// 페이징 첫번째, 마지막 페이지 알럿
let preves = document.querySelectorAll(".prev");
let nextes = document.querySelectorAll(".next");

for(let i of preves){
	i.addEventListener("click", (e) => {
		if(<%= page_selected%> == 1) {
			e.preventDefault();
			alert("첫번째 페이지 입니다.");
		} 
	})
}

for(let i of nextes){
	i.addEventListener("click", (e) => {
		if(<%= page_selected%> == <%= total_page%>) {
			e.preventDefault();
			alert("마지막 페이지 입니다.");
		} 
	})
}
</script>
</body>
</html>