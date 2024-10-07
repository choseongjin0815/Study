package collect.lambda;
interface AAA{
	void abc();
}
class BBB{
	void bcd() {
		System.out.println("B 메서드 1");
	}
}
public class LambdaSample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//#1. A를 구현한 클래스에 abc() 내부에서 B객체를 접근하는 익명 이너 클래스
		AAA a = new AAA() {
			@Override
			public void abc() {
				BBB b1 = new BBB();
				b1.bcd();
			}
		};
		a.abc();
		
		AAA al = () -> {
			BBB b2 = new BBB();
			b2.bcd();
		};
		
		al.abc();
		
		BBB bb = new BBB();
		AAA a3 = bb::bcd;
		a3.abc();
		
	}

}
