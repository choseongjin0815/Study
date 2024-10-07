package chap11;

public class ExeInterFace implements D{

	ExeInterFace(){
	
	}
	
	D ddd = new ExeInterFace();
	
	@Override
	public void ccc() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getConnection(String ip, int port) {
	
		System.out.println(ip);
		return "CONN";
	}
	@Override
	public void print() { //default면 패키지를 벗어나면 상속이 안됨......... 디폴트 메소드 상속받은거 오버라이딩.... 
		System.out.println(false);
	}
	
	public void test() {
		System.out.println("추가메서드");
	}

}
