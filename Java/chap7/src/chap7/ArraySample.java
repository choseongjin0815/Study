package chap7;

public class ArraySample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventBbs[] arrEventList = new EventBbs[5];
		arrEventList[0] = new EventBbs(1, "홍길동", "010-3360-2622", "서울 강남 논현", "xx아파트 102동", "edsd22@naver.com", "8815");
		arrEventList[1] = new EventBbs(2, "홍길순", "010-4360-3622", "서울 강북 번동 ", "xy아파트 202동", "asddsd22@naver.com", "8815");
		arrEventList[2] = new EventBbs(3, "김길동", "010-5660-2632", "경기 안양 만안", "xx아파트 301동", "gasddsd22@naver.com", "8815");
		arrEventList[3] = new EventBbs(4, "김동현", "010-5360-2642", "서울 깅븍 수유", "xx아파트 401동", "gcvdsd22@naver.com", "8815");
		arrEventList[4] = new EventBbs(5, "이재욱", "010-6260-2832", "서울 동작 상도 ", "xx아파트 503동", "23ddsd22@naver.com", "8815");
		
		System.out.print("글번호 : \t");
		System.out.print("작성자 : \t");
		System.out.print("연락처 : \t\t");
		System.out.print("이메일 : \t\t");
		System.out.print("주소 : \t\t");
		System.out.print("상세주소 : \t");
		System.out.println("비밀번호 : ");
		
		for(EventBbs bbs : arrEventList) {
			
			
			System.out.println("=====================================================================================================");
			
			System.out.print(bbs.getBbsNo() + "\t");
			System.out.print(bbs.getUserName() + "\t");
			System.out.print(bbs.getPhoneNo() + "\t");
			System.out.print(bbs.getEmail() + "\t");
			System.out.print(bbs.getAddr1() + "\t");
			System.out.print(bbs.getAddr2() + "\t");
			System.out.println(bbs.getPwd());
					
		}
		
		System.out.println("1. 이전 페이지 :");
		System.out.println("2. 다음 페이지 :");
		System.out.println("3. 글등록 :");
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		EventBbs[] arrEventList2 = new EventBbs[5];
		System.arraycopy(arrEventList, 0, arrEventList2, 0, 5);
		for(EventBbs bbs : arrEventList2) {
			System.out.print(bbs.getBbsNo() + "\t");
			System.out.print(bbs.getUserName() + "\t");
			System.out.print(bbs.getPhoneNo() + "\t");
			System.out.print(bbs.getEmail() + "\t");
			System.out.print(bbs.getAddr1() + "\t");
			System.out.print(bbs.getAddr2() + "\t");
			System.out.println(bbs.getPwd());
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		EventBbs[] arrEventList3 = arrEventList2;
		for(EventBbs bbs : arrEventList3) {
			System.out.print(bbs.getBbsNo() + "\t");
			System.out.print(bbs.getUserName() + "\t");
			System.out.print(bbs.getPhoneNo() + "\t");
			System.out.print(bbs.getEmail() + "\t");
			System.out.print(bbs.getAddr1() + "\t");
			System.out.print(bbs.getAddr2() + "\t");
			System.out.println(bbs.getPwd());
		}
	
	}

}
