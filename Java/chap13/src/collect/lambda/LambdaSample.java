package collect.lambda;

interface A {
	public abstract void abc();
}

class B implements A {
	@Override 
	public void abc() 
	{
		System.out.println("일반 클래스");
	}
}


public class LambdaSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//#1. 일반 클래스 인스턴스 생성
		A a1 = new B();
		a1.abc();	
		//#2. 익명 이너클래스 사용
		A a2 = new A() {
			@Override
			public void abc() {
				System.out.println("익명 이너클래스");
			}
		};
		a2.abc();
		//#3. 람다식으로 표현
		A a3 = () -> System.out.println("람다식");
		a3.abc();
	}

}
