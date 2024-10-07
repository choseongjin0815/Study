package InnerClassStudy;

public class InnerClass { //B의 입장에서 아우터클래스(이너클래스가 없으면 그냥 클래스)
	//아우터클래스의 프로퍼티
	public int a = 3;
	protected int b = 4;
	int c = 5;
	private int d = 6;
	public int[] aa;
	static int h = 18;
	
	//아우터클래스의 메소드
	//이너클래스에서 아우터 클래스 접근할때 private도 됨.
	public void mPublic() {}
	
	protected void mProtected() {}
	
	void mDefault() {}
	
	private void mPrivate() {}
	//이너클래스
	//단발성으로 쓰는 애들에 쓸것
	class B {
		InnerClass FF = new InnerClass();
		public int a = 5;
		
		public void mPublic() {}
		
		void abc() {
			System.out.println("OUTER a : " + FF.a);
			System.out.println("OUTER a : " + InnerClass.this.a);
			System.out.println("OUTER a : " + a);
			System.out.println("OUTER a : " + b);
			System.out.println("OUTER a : " + c);
			System.out.println("OUTER a : " + d);
			
			mPublic();
			mProtected();
			mDefault();
			mPrivate();
		}
		//static void staticMethodInner() {}->static method는 타입.staticmethod로 사용을 하므로 무조건 최상단에 있는 클래스에서만(상속때말하는게 아니라 이너 아우터관계에서) 사용가능 
		//즉 원뎁스 안으로 들어가는 애들은 static으로 선언 불가함. 쓰고 싶으면 parent 타입이 static
	}
	
	
	
	
	class D extends InnerClass{}
	
	//??????
	static class J{
		public int l = 3;
		public static int k = 5;
		public void staticClassPrint() {
			System.out.println("static method");
		}
		static void staticMethodStaticClass() {
			System.out.println("static method in static class");
		}
	}
	
}
