package chap9;

public class Dog extends Animal{
	
	public Dog() {}
	
	public Dog(String dBreed, int dNumAni, int dPrice) {
		this.breed = dBreed;
		this.numAnimal = dNumAni;
		this.price = dPrice;
	}
	
	public void printInfo() {
		System.out.println(this.breed + " " + this.numAnimal + " " + this.price);
	}
	public int getTotalPrice() {
		return this.numAnimal * this.price;
	}
}
