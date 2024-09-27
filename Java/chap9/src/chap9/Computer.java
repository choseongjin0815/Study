package chap9;

public abstract class Computer {
	
	public abstract void display();
	public abstract void typing();
	
	public void turnOn() {
		System.out.println("동작을 시작합니다.");
	}
	public void turnOff() {
		System.out.println("동작을 끝냅니다.");
	}
	
	final void run() {
		turnOn();
		display();
		typing();
		turnOff();
	}
}
