package chap12Latest;
import java.util.Stack;
public class StackSample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		// #1. push
		stack.push(2);
		stack.push(5);
		stack.push(3);
		stack.push(7);
		System.out.println("========================================");
		//#2. peek
		System.out.println(stack.peek());
		//vector의 메서드 그대로 쓸 수 있음(상속받아서)
		System.out.println(stack.size());
		System.out.println(stack.firstElement());
		
		for(int i = 0; i < stack.size(); i++) {
			System.out.println(stack.get(i));
		}
		System.out.println("========================================");
		//#3. int search(Object)
		System.out.println(stack.search(3));
		System.out.println(stack.search(4));//없는거는 -1로 처리
		//#4.pop()
		System.out.println("========================================");
		//무조건 마지막거부터 뽑아온다. arg없음
		System.out.println(stack.pop()+ " : " + stack);
		System.out.println(stack.pop()+ " : " + stack);
		System.out.println(stack.pop()+ " : " + stack);
		System.out.println(stack.pop()+ " : " + stack);
		//#5.empty
		System.out.println(stack.empty());
		stack.push(5);
		System.out.println(stack.empty());
		stack.clear();//vector에 있으니까
		System.out.println(stack.empty());
		System.out.println(stack.isEmpty());
	}

}
