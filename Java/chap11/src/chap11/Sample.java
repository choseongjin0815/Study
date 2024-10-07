package chap11;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		E e = new E() {
			@Override
			public void abc() {
				System.out.println("익명이너클래스를통한인터페이스new");
				test1();
				test2();
				test3();
			}
			
			public void test1() {System.out.println("1");}
			public void test2() {System.out.println("2");}
			public void test3() {System.out.println("3");}
			
		};
		e.abc();
		
		E f = new F();
		E ff = new F();
		E fff = new F();
		
		f = ff = fff;
		
		//e.test1();익명 이너 클래스에서 새로 등록한 메소드는 이런식으로 사용불가능함 
		//밖에서 직접 새로 생성한 메소드에는 접근 불가능하다. 인터페이스에 정의된 함수 외에는 접근불가능
		
	}

}
