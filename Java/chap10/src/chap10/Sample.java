//package chap10;
//
//public class Sample {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//부모클래스 변수 = new 부모클래스();
//		//부모클래스 변수 = new 자식클래스();
////		Human student = new Student();
////		Human job = new Job();
//		
////		student.eat();
////		student.sleep();
//		//student.goToSchool(); 부모클래스 타입으로 지정해서 안됨
//		
//		
////		job.eat();
////		job.sleep();
//		//job.goToCompany(); 부모클래스 타입으로 지정해서 안됨
//		
//		NoticeImpl[] bbs = new NoticeImpl[3];
//		bbs[0] = new NoticeImpl();
//		bbs[1] = new NoticeImpl();
//		bbs[2] = new NoticeImpl();
//		
//		bbs[0].setIdx(1);
//		bbs[0].setName("홍길동");
//		bbs[0].setEmail("aaa@email.net");
//		bbs[0].setUserId("user1");
//		bbs[0].setPwd("1234");
//		bbs[0].setTitle("제목");
//		bbs[0].setContent("글내용");
//		bbs[0].setDisplayDate("2024-10-10");
//		bbs[0].setRegDate("2024-09-04");
//		
//		bbs[1].setIdx(2);
//		bbs[1].setName("조성진");
//		bbs[1].setEmail("bbb@email.net");
//		bbs[1].setUserId("user2");
//		bbs[1].setPwd("1234");
//		bbs[1].setTitle("제목");
//		bbs[1].setContent("글내용");
//		bbs[1].setDisplayDate("2024-10-10");
//		bbs[1].setRegDate("2024-09-04");
//		
//		bbs[2].setIdx(3);
//		bbs[2].setName("홍길동");
//		bbs[2].setEmail("ccc@email.net");
//		bbs[2].setUserId("user3");
//		bbs[2].setPwd("1234");
//		bbs[2].setTitle("제목");
//		bbs[2].setContent("글내용");
//		bbs[2].setDisplayDate("2024-10-10");
//		bbs[2].setRegDate("2024-09-04");
//
//		String[][] bbsContent = new String[3][];
//		for(int i = 0; i < 3; i++) {
//			bbsContent[i] = new String[] {
//					String.valueOf(bbs[i].getIdx()), //기초자료형을 String으로 변환
//					bbs[i].getName(),
//					bbs[i].getEmail(),
//					bbs[i].getUserId(),
//					bbs[i].getPwd(),
//					bbs[i].getTitle(),
//					bbs[i].getContent(),
//					bbs[i].getDisplayDate(),
//					bbs[i].getRegDate()	
//			};
//		
//			bbs[i].regist(bbsContent[i]);
//		}
//		
//		
//		
//		
////		bbs.view(1);
//		bbs[0].bbsList(1,4,"a", "b");
//		bbs[0].delete();
////		bbs.bbsList(1, 1, "카테고리", "키워드");
//		//리스트를 출력
//		//글내용을 출력
//		//글 삭제 처리
//		
//
//	}
//}
