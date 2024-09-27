package chap8;

public class Animal {
	String test = "animal test";
	String human = "테스트";
	public Animal() {}
	public Animal(String co) {
		this.common = co;
	}
	public Animal(String co, String aName, int aAge) {
		this.common = co;
		this.name = aName;
		this.age = aAge;
	}
	
	String common = "공통정보";
	String name;
	int age;
	
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println("class Animal");
	}
	
	void cry() {
		System.out.println("동물동물운다");
	}
	
	
	
	
}
