package chap12;

public class Member {
	private int memberId;
	private String memberName;
	
	public Member(int mId, String mName) {
		this.memberId = mId;
		this.memberName = mName;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "member ID : " + this.memberId + "member Name : " + this.memberName;				
	}
	
	
}
