package chap9;

class A {
	final int a;
	int b;
	
	A(){
		a = 3;
		b = 5;
	}
	
	int abc() {
		final int c = 8;
		return c;
	}
	int c = 5;
	final void testFinalMethod() {
		System.out.println("되나?");
	}
}

class B extends A {
//	@Override
//	void testFinalMethod() {
//		System.out.println("됨?");
//	}
}

public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		System.out.println(a.abc());
		System.out.println(a.c);
		

	}

}
