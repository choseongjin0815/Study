package collections;
import java.util.HashSet;
class Member {
	String name;
	int id;
	
	public Member(String name, int id) {
		this.name = name;
		this.id = id;
	}
}


public class SetPractice {
	HashSet<Member> mem = new HashSet<>();
	mem.add(new Member("조성진", 1));
}
