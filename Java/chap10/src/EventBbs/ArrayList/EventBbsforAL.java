package EventBbs.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;




public class EventBbsforAL implements BasicBbsInterface{
	public EventBbsforAL() {}
	public EventBbsforAL(int idx, String title, String name, String email
			, String startDate, String endDate, String registDate, String contentIdx
			, String content) {
		this.idx = idx;
		this.title = title;
		this.name = name;
		this.email = email;
		this.startDate = startDate;
		this.endDate = endDate;
		this.registDate = registDate;
		this.contentIdx = contentIdx;
		this.content = content;
		
	}
	
	String title;
	String email;
	String name;
	String startDate;
	String endDate;
	String registDate;
	String content;
	String contentIdx;
	int idx;
	
	@Override
	public void bbsList(ArrayList<EventBbsforAL> post, int pageSize, int pageNo) {
		int pageCnt = 0;
		for(int i = 0; i  < post.size(); i++) {
			if(i==0) ++pageCnt;
			else if(i % pageSize == 0) ++pageCnt;
			
			if(pageCnt == pageNo) 
				post.get(i).showInfo();

		}
	}
	
	class B{}
	static class C{}
	
	@Override
	public void view(ArrayList<EventBbsforAL> post, int bbsIdx) {
		post.get(bbsIdx-1).showInfo();
	}
	public void bbsMenu() {
		System.out.println("이벤트 게시판에서 어떤 작업을 하실건가요?");
		
		System.out.println("1. [글등록 || 1]\n2. [검색 || 2]\n3. [글조회 || 3]\n"
				+ "4. [끝내기 || 4]\n5. [더미생성 || 5]\n6. [삭제 || 6]"
				+ "\n7. [수정 || 7]\n8. [특정페이지 조회 || 8]\n9. [인덱스로조회 || 9]"
				+ "\n10. [페이지개수 || 10]" );
		System.out.print(">>>");
	}
	
	public void createBbsEle(ArrayList<EventBbsforAL> post, int eleNumber) {
		Scanner sc = new Scanner(System.in);
		System.out.println("게시글을 몇개 등록하실 건가요?");
		int postNo = sc.nextInt();
		System.out.println("제목 이름 이메일 시작일 종료일 등록일 내용을 입력해주세요");
			for(int i = 0; i < postNo; i++) {
				System.out.print("제목 : ");
				String title = sc.next();
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("이메일 : ");
				String email = sc.next();
				System.out.print("시작일 : ");
				String startDate = sc.next();
				System.out.print("종료일 : ");
				String endDate = sc.next();
				System.out.print("등록일 : ");
				String registDate = sc.next();
				System.out.print("내용 : ");
				String content = sc.next();
				System.out.println("=============================="+(i+1)+"=================================");
				
				post.add(new EventBbsforAL(eleNumber, title, name, email, startDate, endDate, registDate, "게시글" + eleNumber, content));
			}
		}
	
	public void printList(ArrayList<EventBbsforAL> post, int pageSize) {
		int pageCnt = 0;
		for(int i = 0; i  < post.size(); i++) {
			if(i==0) System.out.println(">>>>" + ++pageCnt + "페이지입니다.>>>>");
			else if(i % pageSize == 0) System.out.println(">>>>" + ++pageCnt + "페이지입니다.>>>>" );
			post.get(i).showInfo();

		}
	}
	
	public void searchTitle(ArrayList<EventBbsforAL> post, int pageSize, String inputTitle) {
		int cnt = 0;
		int pageCnt = 0;
		for(EventBbsforAL item : post) {
			if(item.title.equals(inputTitle)) {		
				if(cnt % pageSize == 0) System.out.println(">>>>" + ++pageCnt + "페이지입니다.>>>>" );
				cnt++;
				item.showInfo();				
			}
		}
	}
	
	public void searchContent(ArrayList<EventBbsforAL> post, int pageSize, String inputContent) {
		int cnt = 0;
		int pageCnt = 0;
		for(EventBbsforAL item : post) {
			if(item.content.contains(inputContent)) {
				if(cnt % pageSize == 0) System.out.println(">>>>" + ++pageCnt + "페이지입니다.>>>>" );
				cnt++;
				item.showInfo();
			}
		}
	}
	
	public void createdummy(ArrayList<EventBbsforAL> post, int eleNumber){
		post.add(new EventBbsforAL(eleNumber, "제목"+eleNumber, "이름"+eleNumber, "이메일"+eleNumber,
				"시작일"+eleNumber, "종료일"+eleNumber, "등록일"+eleNumber, "게시글" + eleNumber, "게시글내용"+eleNumber));
	}
	
	public void modifyBbsEle(ArrayList<EventBbsforAL> post) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 컬럼과 인덱스번호를 입력하세요");
		System.out.println("1.제목 2.이름 3.이메일 4.게시글내용");
		System.out.print("column>>>");
		int modifyColumnNo = sc.nextInt();
		System.out.print("idx>>>");
		int modifyIdx = sc.nextInt();
		System.out.print("바뀌게 될 값을 입력해주세요>>>");
		String modifyValue = sc.next();
		if(modifyIdx < post.size()){
			if(modifyColumnNo == 1) {
				post.get(modifyIdx-1).title = modifyValue;
			}
			else if(modifyColumnNo == 2) {
				post.get(modifyIdx-1).name = modifyValue;
			}
			else if(modifyColumnNo == 3) {
				post.get(modifyIdx-1).email = modifyValue;
			}
			else if(modifyColumnNo == 4) {
				post.get(modifyIdx-1).content = modifyValue;
			}
		}
		else {
			System.out.println("존재하는 게시글의 인덱스를 초과하였습니다.");
		}
	}
	
	void showInfo() {
		System.out.println(this.idx + " " + this.title + " " + this.name + " " + this.email + " " +
				this.startDate + " " + this.endDate + " " + this.registDate + " " + this.contentIdx + " " + this.content); 
	}
	
	public int numberOfPage(ArrayList<EventBbsforAL> post , int pageSize) {
		int lastPage = (int)Math.ceil((double)post.size() / pageSize);
		return lastPage;
		
	}
		
	
	
}
