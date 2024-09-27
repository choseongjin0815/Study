package chap10;

import java.util.Arrays;

public class EventBbsImpl implements BasicBbsIf {
	String title;
	String name;
	String startDate;
	String endDate;
	String registDate;
	String content;
	String contentIdx;
	int idx;
	
	
	public String getContentIdx() {
		return contentIdx;
	}

	public void setContentIdx(String contentIdx) {
		this.contentIdx = contentIdx;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	String[][] bbs = {
			{"1","제목1", "홍길동", "2024-01-01", "2024-12-31", "2024-01-01", "콘텐츠1", "게임이벤트"},
			{"2","제목2", "김길동", "2024-01-02", "2024-12-31", "2024-01-02", "콘텐츠2", "경품이벤트"},
			{"3","제목3", "강길동", "2024-01-03", "2024-12-31", "2024-01-03", "콘텐츠3", "추첨이벤트"},
			{"4","제목4", "이길동", "2024-01-04", "2024-12-31", "2024-01-04", "콘텐츠4", "순위이벤트"},
			{"5","제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "경품이벤트"},
			{"6","제목6", "홍길동", "2024-01-06", "2024-12-31", "2024-01-01", "콘텐츠6", "게임이벤트"},
			{"7","제목7", "김길동", "2024-01-07", "2024-12-31", "2024-01-02", "콘텐츠7", "경품이벤트"},
			{"8","제목8", "강길동", "2024-01-08", "2024-12-31", "2024-01-03", "콘텐츠8", "추첨이벤트"},
			{"9","제목9", "이길동", "2024-01-09", "2024-12-31", "2024-01-04", "콘텐츠9", "순위이벤트"},
			{"10","제목10", "박길동", "2024-01-10", "2024-12-31", "2024-01-05", "콘텐츠10", "경품이벤트"},
			{"11","제목11", "홍길동", "2024-01-11", "2024-12-31", "2024-01-01", "콘텐츠11", "게임이벤트"},
			{"12","제목12", "김길동", "2024-01-12", "2024-12-31", "2024-01-02", "콘텐츠12", "경품이벤트"},
			{"13","제목13", "강길동", "2024-01-13", "2024-12-31", "2024-01-03", "콘텐츠13", "추첨이벤트"},
			{"14","제목14", "이길동", "2024-01-14", "2024-12-31", "2024-01-04", "콘텐츠14", "순위이벤트"},
			{"15","제목15", "박길동", "2024-01-15", "2024-12-31", "2024-01-05", "콘텐츠15", "경품이벤트"},
			{"16","제목16", "이길동", "2024-01-16", "2024-12-31", "2024-01-04", "콘텐츠16", "순위이벤트"},
			{"17","제목17", "박길동", "2024-01-17", "2024-12-31", "2024-01-05", "콘텐츠17", "경품이벤트"},
			{"18","제목18", "홍길동", "2024-01-18", "2024-12-31", "2024-01-01", "콘텐츠18", "게임이벤트"},
			{"19","제목19", "김길동", "2024-01-19", "2024-12-31", "2024-01-02", "콘텐츠19", "경품이벤트"},
			{"20","제목20", "강길동", "2024-01-20", "2024-12-31", "2024-01-03", "콘텐츠20", "추첨이벤트"},
			{"21","제목21", "이길동", "2024-01-21", "2024-12-31", "2024-01-04", "콘텐츠21", "순위이벤트"},
			{"22","제목22", "박길동", "2024-01-22", "2024-12-31", "2024-01-05", "콘텐츠22", "경품이벤트"}
		};
	
	String[][] rBbs;

	public void showBbs() {
		for (String[] entry : bbs) {
			System.out.println(Arrays.toString(entry));
		}
	}
	// 새로운 데이터를 bbs에 추가하는 메소드
	public void addBbs(String[] newEntry) {
		bbs = Arrays.copyOf(bbs, bbs.length + 1);
		bbs[bbs.length - 1] = newEntry;
		System.out.println("새로운 데이터가 성공적으로 추가되었습니다.");
	}

	// 특정 인덱스의 데이터를 삭제하는 메소드 (1-based index)
	public void deleteBbs(int bbsIdx) {
		if (bbsIdx < 1 || bbsIdx > bbs.length) {
			System.out.println("유효하지 않은 인덱스입니다.");
			return;
		}

		String[][] newBbs = new String[bbs.length - 1][];
		for (int i = 0, j = 0; i < bbs.length; i++) {
			if (i == bbsIdx - 1) {
				continue; // 삭제할 데이터를 건너뜀
			}
			newBbs[j++] = bbs[i];
		}
		bbs = newBbs;
		System.out.println("데이터가 성공적으로 삭제되었습니다.");
	}
	
	@Override
	public void bbsList(int pageSize, int pageNo) {
		System.out.println("==============================EventBbs List==============================");
		int pageCnt = 0;
		if(pageNo > bbs.length) {
			System.out.println("초과된 값을 입력하였기 때문에 게시글수 만큼만 길이가 설정됩니다.");
			pageNo = bbs.length;
		}
		
		
		for(int i = 0; i < pageNo; i++) {
			if(i == 0) {
				pageCnt += 1;
				System.out.println(">>>>페이지" + pageCnt +">>>>");
				}
			else if ( i >= pageSize && i % pageSize == 0) {
				pageCnt += 1;
				System.out.println(">>>>페이지" + pageCnt +">>>>");
			}
			for(int j = 0; j < bbs[0].length; j++) {
					System.out.print(bbs[i][j] + " ");
					if(j == 7) System.out.println();
				}
			}
		}
		
//	public void addBbs(String[] bbsElement) {
//	
//		
//		
//	}

	
	

	public void searchBbsList(int pageSize, int pageNo, String searchKeyword, String searchCategory) {
		int categoryMark = 100;
		int pageCnt = 0;
		int elCnt = 0;
		int beforElCnt = 0;
		if(searchCategory == "title") categoryMark = 1;
		else if(searchCategory == "content") categoryMark = 7;
		
		System.out.println("==========================search Keyword \"" + searchKeyword + "\"==================================");
	
		if(pageNo > bbs.length) {
			System.out.println("초과된 값을 입력하였기 때문에 게시글수 만큼만 길이가 설정됩니다.");
			pageNo = bbs.length;
		}
		
		for(int i = 0; i < pageNo; i++) {
			if(i == 0) {
				pageCnt += 1;

				System.out.println(">>>>페이지" + pageCnt +">>>>");
			}
			if ( beforElCnt!= elCnt && elCnt >= pageSize && elCnt % pageSize == 0) {
				beforElCnt = elCnt;
				pageCnt += 1;
				System.out.println(">>>>페이지" + pageCnt +">>>>");
			}
			for(int j = 0; j < bbs[0].length; j++) {
				if(bbs[i][categoryMark] == searchKeyword && j != 0) {
					elCnt++;
					System.out.print(bbs[i][j] + " ");
					if(j == 7) System.out.println();
				}
			}


		}

	}
	

	@Override
	public void regist(String[] arrInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public void view(int bbsIdx) {
		System.out.println("==============================" + bbsIdx + "번째 게시글 검색 ==================================");
		for(int i = 0; i < bbs[bbsIdx-1].length; i++) {
			if(i != 0) System.out.print(bbs[bbsIdx][i] + " ");
			if(i == (bbs[bbsIdx].length - 1)) System.out.println();
		}

	}

	@Override
	public void delete(int bbsIdx) {
		// TODO Auto-generated method stub
		System.out.println("=================================데이터 삭제=====================================");
		for(int i = 0; i < bbs[bbsIdx-1].length; i++) {
			if(i != 0) System.out.print(bbs[bbsIdx-1][i] + " ");
			if (i == (bbs[bbsIdx-1].length-1) ) {
				System.out.println("데이터를 삭제합니다.");
			}
		}

	}
	
	public void showPage(int page) {
		int realPageNo;
		page += 1;
		realPageNo = page;
		page *= 10;
		System.out.println("=============================== 페이지" + realPageNo + "의 목록=============================== ");
		for(int i = page-10; i < page; i++) {
			
				for(int j = 0; j < bbs[page].length; j++) {
					if(j != 0) {
						System.out.print(bbs[i][j] + " ");
					}
				
				}
			
			System.out.println();
		}
	}

}
