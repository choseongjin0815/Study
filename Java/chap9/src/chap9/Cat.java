package chap9;

public abstract class Cat extends Animal{
	public Cat() {}
	
	public Cat(String cBreed, int cNumAni, int cPrice) {
		this.breed = cBreed;
		this.numAnimal = cNumAni;
		this.price = cPrice;
	}
	
	public void printInfo() {
		System.out.println(this.breed + " " + this.numAnimal + " " + this.price);
	}
}
