package chap7;
import java.util.ArrayList;
class BookLib{
	public BookLib() {}
	
	public BookLib(String bn, String ath) {
		this.bookName = bn;
		this.author = ath;
	}
	
	String bookName;
	String author;
}


public class ArrayAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookLib[] book = new BookLib[5];
		for(int i = 0; i < 5; i++) {
			book[i] = new BookLib("책이름"+(i+1), "저자"+(i+1));
			System.out.println(book[i].bookName + "  " + book[i].author);
		}
		
		ArrayList<BookLib> bList = new ArrayList<>();
		bList.add(new BookLib("해리포터", "롤링"));
		bList.add(new BookLib("백설공주", "몰라"));
		bList.add(new BookLib("구운몽", "글쎄누구지"));
		bList.add(new BookLib("트와일라잇", "외국사람인듯"));
		bList.add(new BookLib("피터팬", "옛날사람이겠지"));
		
		for(int i = 0; i < bList.size(); i++) {
			System.out.println("책이름 : " + bList.get(i).bookName + "저자 : " + bList.get(i).author);
		}
	
		System.out.println(bList.remove(1));
		
		
	}

}
