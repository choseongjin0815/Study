package chap11;

public interface C {
	public static final int a = 3;
	public String ip = "192.168.1.254";
	public int port = 3306;
	public abstract String getConnection(String ip, int port);
	default void print() {
		System.out.println("PRINT");
	}
	public final int b = 2;//static 븥여줌
	public int c = 0;
	int d = 0;
	public abstract void ccc(); //접근 지정자는 인터페이스보다 같거나 크게, abstract빠지면 컴파일러가 자동으로 abstract추가해줌
}
