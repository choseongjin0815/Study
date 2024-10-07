package chap12Latest;
import java.util.LinkedList;
import java.util.Queue;
public class QueueSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q1 = new LinkedList<Integer>(); //linkedlist는 큐를 상속받아서 만들어서 가능
		if(q1 != null && !q1.isEmpty()) {
			System.out.println(q1.element());
		}
		
		try {
			System.out.println(q1.element());
		} 
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		q1.add(3);
		q1.add(4);
		q1.add(5);
		System.out.println(q1.element());
		//System.out.println(q1.remove(q1));
		System.out.println("========================");
		Queue<Integer> q2 = new LinkedList<Integer>();
		
		q2.add(3);
		q2.add(4);
		q2.add(5);
		q2.addAll(q1);
		//remove() 값을 주게 되면 마주치는 제일 앞에 있는놈 안주면 그냥 제일 앞에놈
		System.out.println(q2); //중복은 set인터페이스만 걸러냄
		q2.remove();
		System.out.println(q2);
		q2.remove(4);
		System.out.println(q2);
		q2.remove(5);
		System.out.println(q2);
		q2.remove(4);
		System.out.println(q2);
		q2.remove(q1);
		System.out.println(q2);
		System.out.println("========================");
		Queue<Integer> q3 = new LinkedList<Integer>();
		q3.addAll(q1);
		q3.add(3);
		q3.add(2);
		q3.add(12);
		q3.add(2);
		q3.add(3);
		q3.add(5);
		System.out.println(q3);
		q3.removeAll(q1);
		System.out.println(q3);
		q3.poll();
		System.out.println(q3);
		System.out.println(	q3.poll() +" "+	q3.poll() + " " +q3.poll());
		//#offer()
		q3.offer(1);
		q3.offer(2);
		q3.offer(3);
		System.out.println(q3);
		System.out.println(q3.peek());
		
	}

}
