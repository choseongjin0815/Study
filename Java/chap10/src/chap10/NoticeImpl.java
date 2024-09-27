//package chap10;
//
//public class NoticeImpl implements BasicBbsIf {
//	
//	int idx;
//	int pageSize;
//	int pageNo;
//	String searchCategory;
//	String searchWord;
//	String name;
//	String pwd;
//	String userId;
//	String email;
//	String title;
//	String content;
//	String regDate;
//	String displayDate;
//	
//	
//	public int getPageSize() {
//		return pageSize;
//	}
//
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
//	
//	public int getIdx() {
//		return idx;
//	}
//
//	public void setIdx(int idx) {
//		this.idx = idx;
//	}
//
//	public int getPageNo() {
//		return pageNo;
//	}
//
//	public void setPageNo(int pageNo) {
//		this.pageNo = pageNo;
//	}
//
//	public String getSearchCategory() {
//		return searchCategory;
//	}
//
//	public void setSearchCategory(String searchCategory) {
//		this.searchCategory = searchCategory;
//	}
//
//	public String getSearchWord() {
//		return searchWord;
//	}
//
//	public void setSearchWord(String searchWord) {
//		this.searchWord = searchWord;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(String regDate) {
//		this.regDate = regDate;
//	}
//
//	public String getDisplayDate() {
//		return displayDate;
//	}
//
//	public void setDisplayDate(String displayDate) {
//		this.displayDate = displayDate;
//	}
//
//	
//	@Override
//	public void bbsList(int pageSize, int pageNo, String searchCategory, String searchKeyword) {
//		System.out.println("pageSize : " + pageSize + "pageNo : " + pageNo + "searchCategory : " + searchCategory + "searchKeyword : " + searchKeyword);
//		String[][] arrList = {{"리스트1", "1"},{"리스트2", "2"}};
//		for(String[] arr : arrList) {
//			for(String str : arr) {
//				System.out.print(str);
//			}
//			System.out.println();
//			
//		}
//	}
//
//	@Override
//	public void regist(String[] arrInput) {
//		System.out.println("공지사항을 등록합니다.");
//		for(String item : arrInput) {
//			System.out.println("arrInput item : " + item);
//		}
//
//	}
//
//	@Override
//	public void view(int bbsIdx) {
//		System.out.println("게시글 조회 bbsIdx : " + bbsIdx);
//
//	}
//
//	@Override
//	public void delete() {
//	
//		
//	}
//
//}
