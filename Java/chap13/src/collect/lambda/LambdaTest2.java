package collect.lambda;
interface AA{
	void method1();
}

interface  BB{
	void method2(int a);
}

interface C {
	int method3();
}

interface D {
	double method4(int a, double b);
}
public class LambdaTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA a = new AA() {
			@Override
			public void method1() {
				System.out.println("입력 매개변수 X 리턴값 X");
			}
			
		};
		a.method1();
		
		BB b = new BB() {
			@Override
			public void method2(int a) {
				System.out.println("입력 매개변수 O 리턴값 X" + a);
			}
			
		};
		b.method2(3);
		
		C c = new C() {
			@Override
			public int method3() {
				System.out.println("입력 매개변수 X 리턴값 O");
				return 3;
			}
			
		};
		c.method3();
		
		D d = new D() {
			@Override
			public double method4(int a, double b) {
				System.out.println("입력 매개변수 O 리턴값 O");
				return a+b;
			}
		};
//		d.method4(4, 4.0);
		System.out.println(d.method4(4, 4.9));
		System.out.println("======================아래는 람다식");
		
		//람다식으로 표현
		AA a1 = ()->System.out.println("method A");
		a1.method1();
		
		BB b1 = (s) -> System.out.println("\n"+s);
		b1.method2(3);
		
		C c1 = () -> {System.out.println("\nC");return 3;};
		System.out.println(c1.method3());
		
		D d1 = (s,v) -> {System.out.println("\nD"); return s+v;};
		
		System.out.println(d1.method4(4, 5.0));
		
		
		
		
	}

}
