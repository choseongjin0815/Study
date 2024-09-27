package chap10;



public interface Calculator {
	public static final double PI = 3.14;
	
	public abstract double size(int radius);
	public abstract int add(int n1, int n2);
	public abstract int sub(int n1, int n2);
	public abstract int mul(int n1, int n2);
	public abstract int div(int n1, int n2);
	
	
}
