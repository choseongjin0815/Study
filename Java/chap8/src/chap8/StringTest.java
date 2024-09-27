package chap8;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Abcdefghijabcabbcdedddddaaassdefgklsm";
		System.out.println(str.length());
		System.out.println(str.charAt(3));
		System.out.println(str.indexOf('s'));
		System.out.println(str.lastIndexOf('s'));
		System.out.println(Integer.valueOf(str.charAt(0)));
		System.out.println(str.replace('A', 'Z'));
		System.out.println(str.substring(0, 10));
		//System.out.println(str.split("bb"));
	}

}
