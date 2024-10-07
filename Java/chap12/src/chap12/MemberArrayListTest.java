package chap12;

public class MemberArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberArrayList mArrList = new MemberArrayList();
		
		Member mLee = new Member(1001, "lee");
		Member mKim = new Member(1002, "kim");
		Member mCho = new Member(1003, "cho");
		Member mPark = new Member(1004, "park");
		
		mArrList.addMember(mLee);
		mArrList.addMember(mKim);
		mArrList.addMember(mCho);
		mArrList.addMember(mPark);
		
		mArrList.showAllMember();
	}

}
