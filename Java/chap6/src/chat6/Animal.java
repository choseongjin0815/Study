package chat6;

public class Animal {
	
	String name;
	int height;
	int weight;
	int age;
	
	public Animal() {
		this("고릴라", 7);
	}
	
	public Animal(String aniName, int aniAge) {
		this(200, 150);
		this.name = aniName;
		this.age = aniAge;
	}
	
	public Animal(int aniHeight, int aniWeight) {
		this.height = aniHeight;
		this.weight = aniWeight;
	}
	
	void printAnimalInfo() {
		System.out.println(this.name + " " + this.height + " " + this.weight + " " +
				this.age + " ");
	}
}
