package chap9;

public abstract class Animal {
	
	public String breed;
	public int numAnimal;
	public int price;
	
	void alarm() {
		System.out.println("테스트");
	}
	protected abstract void printInfo();
	public abstract int getTotalPrice();
	
	final public void template() {
		alarm();
		printInfo();
		System.out.println(getTotalPrice());
	}
}
