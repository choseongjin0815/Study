package chap7;

class C {
	int i = 0;
	
	void add() {
		this.i += 1;
	}
}

public class TestC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C a = new C();
		a.add();
		System.out.println(a.i);
		a.add();
		System.out.println(a.i);
		a.add();
		System.out.println(a.i);
	}

}
