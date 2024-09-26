package chap5; //디렉토리 경로 정보를 알려줌

//co.kr.chunjae.www
//co.kr.chunjae.api
//기본 생성자는 사용자가 정의하지 않았을 경우 시스템이 객체 생성시에 자동 생성
//기본 생성자 : 클래스명() {}
//	1.리턴타입이 없다.
//	2.사용자가 정의하지 않아도 시스템에서 자동으로 생성해줌.
// 	3.사용자가 정의한 생성자가 존재할경우 반드시 기본 생성자를 앞에 선언해줘야함.
//생성자는 객체를 메모리에 할당하는 역할
//객체명 변수명 = new 객체명();
//접근제어자 리턴할자료형/void 함수명 () {return 자료형의 값}
//리턴타입이 없을 떄 : 함수명(); //정보한번 출력, 정보 세팅하고 끝낼때
//있을 때 : 자료형 변수명 = 함수명(); //연산한 결과를 받을때
public class Student {
	
	Student() {}
	static int serialNo;
	int studentNo;
	String studentName;
	int grade;
	private char gender;
	String rider;
	private char a; //encapsulation, information hiding 
	
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getRide() {
		return "학생탈것";
	}
	
	public String getRider() {
		return this.rider;
	}
	
	public void setRider(String rider) {
		this.rider = rider;
	}
	static public int get1() {
		return serialNo;
//		return studentNo;
	}
	
//	public Student() {
//		System.out.println("Default Constructor");
//		this.grade = 20;
//	}
//	
//	public Student(int stNo) {
//		this.studentNo = stNo;
//	}
//	
//	public Student(int stNo, String stName, int stG, char stGen) {
//		this.studentNo = stNo;
//		this.studentName = stName;
//		this.grade = stG;
//		this.gender = stGen;
//	}
//	
//	//정보은닉화 getter, setter
//	public char getA() {
//		return this.a; //this는 자기자신 클래스에서는 클래스 자기 자신이 가지고 있는  프로퍼티 a
//	}
//
//	//함수선언시점의 변수의 형태는 매개변수 사용할때는 set의 변수 인자값으로 a를 넣어......
//	public void setA(char a) {
//		this.a = a;
//	}
//
//
//	public void printInfo() {
//		System.out.println("StudentNo : " + this.studentNo + " \nStudenName : " + this.studentName + " \nGrade : "
//				+ this.grade + " \nGender : " + this.gender);
//	}
//	/**
//	 * document남겨야할때
//	 */
//	
//	public String getStudentInfo() {
//		//묵시적 형변환 
//		return "StudentNo : " + this.studentNo + " \nStudenName : " + this.studentName + " \nGrade : "
//				+ this.grade + " \nGender : " + this.gender;
//	}
	
}
