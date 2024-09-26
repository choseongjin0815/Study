package chap7;

import java.util.ArrayList;

class A{
	public String name;
	public int age;
}

class B extends A{
	protected int weight = 60;
	public B() {
		name = "김철수";
		age = 20;
	}
}
class Book {
	String author;
	String bookName;
	public Book() {}
	public Book(String aAuthor, String aBookName) {
		this.author = aAuthor;
		this.bookName = aBookName;
	}
	void showBookInfo(){
		System.out.println("제목 : " + this.bookName + " 저자 : " + this.author );
	}
}


public class ArrTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Book> bookInfo = new ArrayList<Book>();
		
		bookInfo.add(new Book("김찬환" ,"책제목1"));
		bookInfo.add(new Book("강나무" ,"책제목2"));
		bookInfo.add(new Book("박인수" ,"책제목3"));
		bookInfo.add(new Book("크리스" ,"책제목4"));
		bookInfo.add(new Book("요시키" ,"책제목5"));
		
		for(int i = 0; i < bookInfo.size(); i++) {
			Book book = bookInfo.get(i);
			book.showBookInfo();
		}
		
		for(Book book : bookInfo) {
			book.showBookInfo();
		}
		
		bookInfo.remove(0);
		
		for(Book book : bookInfo) {
			book.showBookInfo();
		}
		
		System.out.println(bookInfo.isEmpty());
		
		System.out.println(bookInfo.remove(0).toString());
		System.out.println(bookInfo.remove(0).toString());
		System.out.println(bookInfo.remove(0).toString());
		System.out.println(bookInfo.remove(0).toString());
		
		System.out.println(bookInfo.isEmpty());
		
//		int[][] arr = new int[4][5];
//		int[][] arr = n;
//		arr[0][1] = 3;
//		int[][] arr2 = {{2,2},{2,2}};
//		int[][] arr3 = new int[5][];
//		arr3[0] = new int[3];
//		arr3[0][0] = 1;
//		arr3[0][1] = 2;
//		arr3[0][2] = 3;
		
//		B b = new B();
//		System.out.println(b.name + "," + b.age + "," +b.weight);
		
		//int[][] arr = new int[5][6];
		
		//System.out.println(arr.length);
		
		
	}

}
