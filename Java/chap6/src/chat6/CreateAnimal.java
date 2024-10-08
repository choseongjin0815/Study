package chat6;



class StaticTest{
	static String test = "static test";
	static int tNum;
}


public class CreateAnimal {

	public static void test() {
		System.out.println("static method");
	}
	
	public static void main(String[] args) {

		Animal g = new Animal("고릴라", 13);
		g.printAnimalInfo();
		
		StaticTest.tNum = 30;
		
		System.out.println(StaticTest.test + "  " + StaticTest.tNum);
		
		System.out.println("================아래는 animal을 상속받은 dog==================");
		
		Dog d = new Dog("똘이", 50, 6);
		
		d.printAnimalInfo();
		
		System.out.println("=============this()test===============");
		
		Dog e = new Dog(14, "푸들");
		System.out.println("=========return this=============");
		Dog r = d.returnItself();
		System.out.println(r.breed);
		
		
		test();
		
		System.out.println("==========부모 클래스의 생성자를 super()통해 호출=============");
		Dog s = new Dog();
		System.out.println(s.name + " " + s.age);
	}

}
