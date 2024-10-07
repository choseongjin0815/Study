package chap12;
import java.util.ArrayList;

public class MemberArrayList {
	ArrayList<Member> memberList;
	
	public MemberArrayList() {
		memberList = new ArrayList<>();
	}
	
	public void addMember(Member member) {
		this.memberList.add(member);
	}
	public void removeMember(Member member) {
		this.memberList.remove(0);
	}
	
	public void showAllMember() {
		for(int i = 0; i < this.memberList.size(); i++) {
			System.out.println(memberList.get(i));
		}
	}

}
