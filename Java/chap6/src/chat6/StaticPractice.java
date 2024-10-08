package chat6;
class A {
	int aNo;
	static private int testNo;
	public A () {
		this.aNo = no;
		no++;
	}
	static int no = 1000;
	
	void printNo() {
		System.out.println("static변수 No : " + no + ", aNo : " + this.aNo);
	}
	
	public int getTestNo() {
		return testNo;
	}
}

public class StaticPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A a = new A();
//		a.printNo();
//		A a1 = new A();
//		a1.printNo();
//		a.printNo();
//		A a2 = new A();
//		a2.printNo();
//		a.printNo();
//		a1.printNo();
		A b = new A(); //new한 애들은 클래스안의 영역에 들어가서 변수를 참조하기때문에 접근가능
		System.out.println(b.getTestNo());
		//A.testNo = 1; //private 변수이기 때문에 new를 해주지 않으면 클래스가 생성되지 않았기 때문에 자신의 클래스 안인지 알수없음
	}

}
