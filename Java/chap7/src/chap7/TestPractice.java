package chap7;
import java.util.ArrayList;
class Book1{
	public Book1() {}
	int num;
	
	public Book1(int number) {
		this.num = number;
	}
	
	public int getNum() {
		return this.num;
	}
}


public class TestPractice {
	public static void main(String[] args) {
		
		String str = "asbvfsadsad,sdasdasdasda";
		String arr[] = str.split(",");
		for(String s : arr) {
			System.out.print(s);
			System.out.println();
			
		}
		
		int[] a = new int[] {1,2,3,};
		System.out.println(a[0]);
		System.out.println(arr[0] + "  " + arr[1]);
	
		
		
		ArrayList<Book1> book = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			book.add(new Book1(i));
			System.out.println(book.get(i).getNum());
		}
	}
}
