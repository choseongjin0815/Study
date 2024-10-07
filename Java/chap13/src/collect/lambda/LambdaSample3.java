package collect.lambda;

interface LA3{
	void abc(int k);
}

public class LambdaSample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//#1.인스턴스 메서드의 익명이너클래스
		LA3 a1 = new LA3() {
			@Override
			public void abc(int k) {
				System.out.println(k);
			}
		};
		a1.abc(1);
		
		System.out.println("=========================================");
		//#2.람다식
		LA3 a2 = (a) -> System.out.println(a); //변수 자료형 생략 화살표 뒤 중괄호 생략
		a2.abc(2);
		LA3 a3 = (int a) -> {System.out.println(a);}; 
		a3.abc(3);
		LA3 a4 = (int a) -> System.out.println(a); //화살표 뒤 중괄호 생략
		a4.abc(4);
		LA3 a5 = (a) -> {System.out.println(a);};//변수 자료형 생략 
		a5.abc(5);
		System.out.println("=========================================");
		//#3.람다식 -> 인스턴스 메서드 참조
		LA3 a6 = System.out::println;
		a6.abc(6);
	}

}
