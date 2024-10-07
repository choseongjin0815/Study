package chap12;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C cc = new C();
		A a1 = new B();
		
		cc.bcd(a1);//의존성....
		
		cc.bcd(new B());
		
		//익명 이너 클래스 이용
		A aa = new A() {
			@Override
			public void abc() {
				System.out.println("aa --> abc()");
			}
		};
		cc.bcd(aa);
		
		//익명 이너 클래스 이용2
		cc.bcd(
				new A() {
					@Override
					public void abc() {
						System.out.println("익명 이너 클래스 이용 2");
					}
				});
		
		
		System.out.println("================================");
		G g = new G();
		g.abc();
		//익명이너인터페이스
	new E.F() {
			@Override
			public void abc() {
				System.out.println("익명 인터페이스");
			}
		}.abc();
		//ef.abc();
		
		System.out.println("================================");
		//일반적인  UI API 구조 예(버튼)
		Button btn1= new Button();
		
		btn1.setOnClickListner(new Button.OnClickListner() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("버튼1을 클릭 >> 음악재생");
			}
		});
		
		btn1.onClick();
		
	Button btn2= new Button();
		
		btn2.setOnClickListner(new Button.OnClickListner() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("버튼2을 클릭 >> 음악 종료");
			}
		});
		btn2.onClick();
	}

}
