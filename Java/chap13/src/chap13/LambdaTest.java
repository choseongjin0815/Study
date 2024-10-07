package chap13;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuncInterface f = () -> System.out.println("함수형 인터페이스 테스트");
		f.printTest();

		//return값이 있을때는 중괄호 생략불가능
		FuncAdd a = (s,v) -> {return s+v;};
		System.out.println(a.add(3, 4));
		
		FuncSub c = (s,v) -> {return s-v;};
		System.out.println(c.sub(5, 66));
	}

}
