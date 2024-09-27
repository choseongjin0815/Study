package EventBbs.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
public class CreateEventBbs {

	public static void main(String[] args) 
	{
		int pageCnt = 0;
		int eleNumber = 0; //게시글 개수
		
		EventBbsforAL ebl = new EventBbsforAL();
		ArrayList<EventBbsforAL> post = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("페이지 사이즈를 입력하세요");
		System.out.print(">>>");
		int pageSize = sc.nextInt();
		while(true) {
			
			ebl.bbsMenu();
			String work = sc.next();
			if(work.equals("글등록") || work.equals("1")) {
				eleNumber += 1; 
				ebl.createBbsEle(post, eleNumber);

			}
			else if ((work.equals("검색") || work.equals("2"))) {
				
				if(eleNumber == 0) {
					System.out.println("게시글이 없으므로 검색을 하지 못합니다!");
					continue;
					} //삽입된 게시글이 없으니 검색도 못함
				
				System.out.println("=========================검색========================");
						
				System.out.println("어떤 내용에서 검색할거임? (title OR content)");
				String inputColumn = sc.next();
				int cnt = 0;
				if(inputColumn.equals("title")) {
					System.out.println("어떤 제목을 검색할거임?");
					String inputTitle= sc.next();
					
					ebl.searchTitle(post, pageSize, inputTitle);
					
				}
				else if (inputColumn.equals("content")) {
					System.out.println("어떤 컨텐츠를 검색할거임?");
					String inputContent= sc.next();
					
					ebl.searchContent(post, pageSize, inputContent);

				}
				
			}
			else if(work.equals("3") || work.equals("글조회")) {
				
				ebl.printList(post, pageSize);
				
			}
			else if(work.equals("4") || work.equals("끝내기")) {
				System.out.println("작업을 종료합니다.");
				break;
			}
			else if(work.equals("5") || work.equals("더미생성")) {
				System.out.println("====================테스트용 더미게시글 생성==========================");
				System.out.println("게시글을 몇개 생성하실 건가요?");
				int cNum = sc.nextInt();
				
				for(int i = 0; i < cNum; i++) {
					eleNumber += 1;
					ebl.createdummy(post, eleNumber);
				}
			}
			else if(work.equals("6") || work.equals("삭제")) {
				
				if(eleNumber == 0) {
					System.out.println("게시글이 없으므로 삭제를 하지 못합니다!");
					continue;
					} //삽입된 게시글이 없으니 삭제도 못함
				
				System.out.println("삭제할 게시글의 인덱스를 입력해주세요");
				int bIdx = sc.nextInt();
				post.remove(bIdx-1);				
				System.out.println(bIdx + "번째 게시글이 삭제되었습니다.");
				
				
				//삭제한 게시글 이후 인덱스 번호의 게시글 인덱스를 앞으로 이어지게 만들어줌.
				for(int i = (bIdx - 1); i < post.size(); i++ ) {
					post.get(i).idx -= 1;
				}
			}
			else if(work.equals("7") || work.equals("수정")) {
				
				if(eleNumber == 0) {
					System.out.println("게시글이 없으므로 수정을 하지 못합니다!");
					continue;
					} //삽입된 게시글이 없으니 수정도 못함
				ebl.modifyBbsEle(post);
			}
			else if(work.equals("8") || work.equals("특정페이지조회")) {
				if(eleNumber == 0) {
					System.out.println("게시글이 없으므로 조회를 하지 못합니다!");
					continue;
				} //삽입된 게시글이 없으니 수정도 못함
				System.out.println("몇페이지를 조회하시겠어요?");
				int pageNo = sc.nextInt();
			
				System.out.println("=============="+pageNo+"페이지를 조회합니다.================");
				ebl.bbsList(post, pageSize, pageNo);
			}
			else if(work.equals("9") || work.equals("인덱스로조회")) {
				if(eleNumber == 0) {
					System.out.println("게시글이 없으므로 조회를 하지 못합니다!");
					continue;
				} //삽입된 게시글이 없으니 수정도 못함
				System.out.println("확인하고 싶은 게시글의 인덱스를 입력하세요");
				int bbsIndex = sc.nextInt();
				if(bbsIndex > post.size()) {
					System.out.println("게시글의 수보다 큰 인덱스입니다.");
					continue;
				}
				ebl.view(post, bbsIndex);
			}
			else if(work.equals("10") || work.equals("페이지개수")) {
				System.out.println("페이지수는 "+ebl.numberOfPage(post, pageSize)+"개 입니다.");  
			}
						
		}
					
	}
}
		
	


