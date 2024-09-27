package chap8;

public class Human extends Animal{
	String test = "human test";
	String human = "사람";
	String job;
	public Human() { 
		//super("Human");
	}
	public Human(String hJob) {
		super("사람정보", "조성진", 26);
		this.job = hJob;
	}
	
	void printSuper() {
		System.out.println(this.human);
		System.out.println(super.human);
	}
	
	void showHumanInfo() {
		System.out.println(this.job + " " + this.common + " " + this.name + " " +
				this.age + " "+ this.human);
		System.out.println(this.job + " " + super.common + " " + super.name + " " +
				super.age + " "+ super.human);
		
	}
	
	@Override
	public void printInfo() {
		//super.printInfo();
		System.out.println("class Human");
	}
	
	@Override
	void cry() {
		System.out.println("엉엉");
	}
}
