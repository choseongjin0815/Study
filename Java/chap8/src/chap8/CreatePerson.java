package chap8;

class Person {
	String name;
	int age;
	
	void eat() {
		System.out.println("밥먹음");
	}
	
	void sleep() {
		System.out.println("잠");
	}	
}

class UnivStudent extends Person{
	int stuNo;
	
	public UnivStudent() {
		//super();생략된것
	}
	public UnivStudent(String uName, int uAge, int uStuNo) {
		this.name = uName;
		this.age = uAge;
		this.stuNo = uStuNo;
	}
	
	void goSchool() {
		System.out.println(this.name + "학교감");
	}
	
	void studentInfo() {
		System.out.println(this.name + " " + this.age + "살  학번 :" + this.stuNo);
	}
	
}

class Employee extends Person{
	int empNo;
	
	public Employee () {}
	
	public Employee (String eName, int eAge, int eEmpNo) {
		
		//super(name,age);
		this.name = eName;
		this.age = eAge;
		this.empNo = eEmpNo;
	}
	
	void goCompany() {
		System.out.println(this.name + "회사감");
	}
	
	void empInfo() {
		System.out.println(this.name + " " + this.age + "살  사번 :" + this.empNo);
	}
}

public class CreatePerson{
	public static void main(String[] args) {
		UnivStudent up = new UnivStudent("조성진", 26, 11111);
		up.goSchool();
		up.studentInfo();
		up.eat();
		up.sleep();
		Employee ep = new Employee("김철수", 31, 22222);
		ep.goCompany();
		ep.empInfo();
		ep.eat();
		ep.sleep();
	}
}

