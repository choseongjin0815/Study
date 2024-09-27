package chap10;

public class Job implements Human {
	int age;
	String name;
	
	public void goToCompany() {
		System.out.println("회사에 갑니다.");
	}
	
	@Override
	public void eat() {
		System.out.println("회사에서 먹습니다.");

	}

	@Override
	public void sleep() {
		System.out.println("회사에서 잡니다.");

	}

}
