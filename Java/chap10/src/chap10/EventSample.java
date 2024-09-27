package chap10;

public class EventSample {
	public static void main(String[] args) {
		EventBbsImpl ebi = new EventBbsImpl();
		
//		ebi.setIdx(23);
//		ebi.setName("조성진");
//		ebi.setStartDate("2024-09-04");
//		ebi.setEndDate("2024-12-31");
//		ebi.setContentIdx("콘텐츠23");
//		ebi.setContent("순위이벤트");
//		ebi.setRegistDate("2024-09-04");
//		ebi.setTitle("제목23");
//		
//		String[] bbsContent = {
//				String.valueOf(ebi.getIdx()),
//				ebi.getTitle(),
//				ebi.getName(),
//				ebi.getStartDate(),
//				ebi.getEndDate(),
//				ebi.getRegistDate(),
//				ebi.getContentIdx(),
//				ebi.getContent()
//		};
//		
//		
//		ebi.addBbs(bbsContent);
//		ebi.bbsList(4, 26);
//		ebi.searchBbsList(4, 23, "제목8", "title");
//		ebi.searchBbsList(5, 20, "경품이벤트", "content");
//		ebi.delete(2);
//		ebi.showPage(1);
//		ebi.view(1);
		String[] newEntry1 = {"5", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry2 = {"5", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry3 = {"5", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry4 = {"5", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry5 = {"6", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry6 = {"6", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry7 = {"6", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry8 = {"6", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry9 = {"7", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry10 = {"7", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry11 = {"7", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		String[] newEntry12 = {"7", "제목5", "박길동", "2024-01-05", "2024-12-31", "2024-01-05", "콘텐츠5", "새로운이벤트"};
		ebi.addBbs(newEntry1);
		ebi.addBbs(newEntry2);
		ebi.addBbs(newEntry3);
		ebi.addBbs(newEntry4);
		ebi.addBbs(newEntry5);
		ebi.addBbs(newEntry6);
		ebi.addBbs(newEntry7);
		ebi.addBbs(newEntry8);
		ebi.addBbs(newEntry9);
		ebi.addBbs(newEntry10);
		ebi.addBbs(newEntry11);
		ebi.addBbs(newEntry12);
		ebi.deleteBbs(3);
		ebi.searchBbsList(4, 22, "제목5", "title");
		ebi.searchBbsList(4, 35, "새로운이벤트", "content");
		
		
		
	
	}

}
