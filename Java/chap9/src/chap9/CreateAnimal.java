package chap9;

public class CreateAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d = new Dog("강아지", 20, 300000);
		d.printInfo();
		System.out.println(d.getTotalPrice());
		d.template();
	}

}
