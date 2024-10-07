package collect.lambda;
interface LA4{
	void abc(LB4 b, int k);
}
class LB4 {
	void bcd(int k) {
		System.out.println(k);
	}
}
public class LambdaSample4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//#1.익명 이너 클래스
		LA4 a1 = new LA4() {
			@Override
			public void abc(LB4 b, int k) {
				b.bcd(k);
			}
		};
		a1.abc(new LB4(), 5);
		
		//#2.람다식
		LA4 a2 = (a, b) -> {a.bcd(b);};
		a2.abc(new LB4(), 6);
		
	
	
	}

}
