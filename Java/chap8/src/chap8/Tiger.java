package chap8;

public class Tiger extends Animal{
	String test = "Tiger test";
	@Override
	public void printInfo() {
		System.out.println("class tiger");
	}
	@Override
	void cry() {
		System.out.println("어흥");
	}
}
