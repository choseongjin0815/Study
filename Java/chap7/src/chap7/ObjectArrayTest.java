package chap7;
class ObjObject{
	int cnt;
	public ObjObject() {}
	public ObjObject(int num) {
		this.cnt = num;
	}
}
public class ObjectArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjObject[] obj = new ObjObject[5];
		for(int i = 0; i < 5; i++) {
			obj[i] = new ObjObject();
			obj[i].cnt = i;
			System.out.println(obj[i].cnt);
		}
		
	}

}
