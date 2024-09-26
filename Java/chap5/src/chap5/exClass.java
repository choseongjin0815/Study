package chap5;

public class exClass {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Student st = new Student();
//		Student st2 = new Student();
//		Student st3 = st;
//		
//		st.setGender('F');
//		st.setStudentName("홍길순");
//		st.setGrade(5);
//		st.setStudentNo(1);
//		
//		st2.setGender('M');
//		st2.setStudentName("홍길동");
//		st2.setGrade(1);
//		st2.setStudentNo(2);
//		
//		System.out.println(st);
//		System.out.println(st2);
//		System.out.println(st3);
//		
//		System.out.println(st.getGender());
//		System.out.println(st.getGrade());
//		System.out.println(st.getStudentName());
//		System.out.println(st.getStudentNo());
//		
//		System.out.println(st2.getGender());
//		System.out.println(st2.getGrade());
//		System.out.println(st2.getStudentName());
//		System.out.println(st2.getStudentNo());
//		
//		System.out.println(st3.getGender());
//		System.out.println(st3.getGrade());
//		System.out.println(st3.getStudentName());
//		System.out.println(st3.getStudentNo());
//		
//		st3.setGender('M');
//		st3.setGrade(3);
//		st3.setStudentName("홍길순2");
//		st3.setStudentNo(11);
//		
//		System.out.println("=====================");
//		//st, st3는 메모리 번지수를 공유
//		System.out.println(st); //JVM이 만들어낸값
//		System.out.println(st3);
//		
//		System.out.println(st.getGender());
//		System.out.println(st.getGrade());
//		System.out.println(st.getStudentName());
//		System.out.println(st.getStudentNo());
//		
//		
//		
//		System.out.println(st3.getGender());
//		System.out.println(st3.getGrade());
//		System.out.println(st3.getStudentName());
//		System.out.println(st3.getStudentNo());
//		
//		System.out.println(System.identityHashCode(st)); //인스턴스가 올라간 메모리 번지값
//		System.out.println(System.identityHashCode(st2));
//		System.out.println(System.identityHashCode(st3));
//		
		
//		Student student = new Student(12, "박철수", 5, 'M');
//		
//		student.printInfo();
//		System.out.println();
//		
//		
//		Student student1 = new Student();
//		student1.gender = 'M'; //'' <-는 안됨 값을 넣어주긴 해야함.
//
//		student1.studentName = "Jade";
//		student1.studentNo = 32;
//		student1.printInfo();
//		System.out.println();
//		
//		Student student2 = new Student(13);
//		student2.gender = 'F'; //'' <-는 안됨 값을 넣어주긴 해야함.
//		student2.grade = 4;
//		student2.studentName = "Made";
//		student2.printInfo();
//		System.out.println("------------------" + "\n"+student2.getStudentInfo());
//		
//		student.setA('T');
//		System.out.println("\n\n" + student.getA());
		
		Student st1 = new Student();
		Student st2 = new Student();
		
		st1.setStudentName("홍길동");
		st1.setRider("BUS");
		st1.setGender('M');
		st1.setGrade(2);
		st1.setStudentNo(20240001);
		
		st2.setStudentName("홍길순");
		st2.setRider("TRUCK");
		st2.setGender('F');
		st2.setGrade(4);
		st2.setStudentNo(20230001);
		
		
		System.out.println(st1.getStudentName()+ "은 " + st1.getRider() + "를 탑니다.");
		System.out.println(st2.getStudentName()+ "은 " + st2.getRider() + "를 탑니다.");
		
		if(st1.getRider() == "BUS") {
			Bus b1 = new Bus();
			b1.setSeatCnt(10);
			b1.setStandCnt(15);
			b1.setCarName("벤츠");
			b1.setCarCC(2000);
			b1.setMaxPerson(45);
			b1.setWheelCnt(6);
			
			System.out.println(b1.getCarName());
		}
		
		if(st2.getRider() == "TRUCK") {
			Truck t1 = new Truck();
			t1.setMaxCharge(10);
			t1.setCarName("트럭");
			t1.setCarCC(4000);
			t1.setMaxPerson(2);
			t1.setWheelCnt(10);
			System.out.println(t1.getCarName());
		}

		Student.serialNo = 10;
		int sn = Student.serialNo;
	}
	

}
