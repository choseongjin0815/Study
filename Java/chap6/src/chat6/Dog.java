package chat6;

public class Dog extends Animal{
	
	String breed; //견종
	
	public Dog() {
		super();
		System.out.println("this()테스트");
	}
	
	public Dog(String dName, int dHeight, int dWeight) {
		this(6, "말티즈");
		this.name = dName;
		this.height = dHeight;
		this.weight = dWeight;
		
	}
	
	public Dog(int dAge, String dBreed) {
		this();
		this.age = dAge;
		this.breed = dBreed;
	}
	
	Dog returnItself() {		
		return this;
	}
	
	@Override
	void printAnimalInfo() {
		System.out.println("강아지 이름 : " + this.name);
		System.out.println("강아지 견종 : " + this.breed);
		System.out.println("강아지 키 : " + this.height);
		System.out.println("강아지 몸무게 : " + this.weight);
		System.out.println("강아지 나이 : " + this.age);
		
	}

}
