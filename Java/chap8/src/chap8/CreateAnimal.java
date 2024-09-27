package chap8;

public class CreateAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human h = new Human("학생");
		h.printSuper();
		System.out.println("=====================================================");
		h.showHumanInfo();
		System.out.println("=====================================================");
		
		Animal b = new Human(); //human에 animal타입 넣는다고 생각
		b.printInfo();//타입이 부모 타입으로 생성해도 오버라이딩을 한경우에는 메소드 영역에 가리켜져 있으므로 Human의 내용이 나옴
		if(b instanceof Human) {
			Human hm = (Human) h;
			System.out.println("=========================================");
			hm.printInfo();
		}
		System.out.println("===========================================");
		Animal ani = new Animal();
		ani.printInfo();
		
		CreateAnimal cr = new CreateAnimal();
		System.out.println("===========================================");
		
		cr.printClassInfo(new Animal());
		cr.printClassInfo(new Human());
		cr.printClassInfo(new Tiger());
		System.out.println("===============================================");
		
		Animal a1 = new Animal();
		Animal b1 = new Human();
		Animal c1 = new Tiger();
		
		
		System.out.println(a1.test);
		a1.printInfo();
		a1.cry();
		System.out.println(b1.test);
		b1.printInfo();
		b1.cry();
		System.out.println(c1.test);
		c1.printInfo();
		c1.cry();
		System.out.println("========================================================");
		cr.printClassInfo(a1);
		cr.printClassInfo(b1);
		cr.printClassInfo(c1);
		System.out.println("========================================================");
		
		Human h1 = null;
		if(h1 instanceof Human) {
			h1 = (Human)new Animal();
		}
		
		
		
		//Human c = new Animal(); // Animal이 Human타입이 될수는 없음 부모가 자식의 내용을 가지고 있지는 않기 때문
		//Human d = (Human)new Animal();

	}
	public void printClassInfo(Animal animal) {
		animal.printInfo();
	}

}
/*
//1.클래스의 구성요소
//프로퍼티(필드)
//-기초자료형
 *참조자료형 (array, 사용자 정의 객체(클래스))
 *-메소드
 *2.클래스가 나오게 된 배경
 *변수로 작업 -> 배열로 작업 -> 구조체(구조는 클래스와 유사하지만 상속할 수 없음) -> 클래스
 *
 *
 *절차 지향형 VS 객체지향형
 *-프로그래밍 순서에 따라 단계적으로 실행하도록 명령어를 나열
 *-객체지향형 : 객체를 구성하고 객체 단위로 프로그래밍(필드 / 메서드) EventDriven방식에 더 적합
 *절차1 자동차를 묘사 - 컬러,엔진 종류 지정
 *절차2 운전자 이름, 면허 번호 등 지정
 *절차3 운전자가 자동차를 운전한다.
 *절차4 사람 감지?
 *절차5 운전자가 자동차를 중지한다.
 *-->절차지향형 방식(기능중심)

 *자동차(객체1)			자동차2(객체2)			운전자(객체3)
 *컬러 				컬러					이름
 *엔진				엔진					운전면허				=>객체중심(기본적인걸만들고가져다쓰는형태 필요한 추가사항은 내가 추가로 넣을수있음)
 *차종				종류					운전하기
 *					구동하기(메소드)
 *					전진, 후진, 정지		
 *===================================================================
 *1.자바 객체 지향의 요소
 *-일반 클래스
 *-추상 클래스
 *	-class 키워드로 정의
 *	-클래스가 abstract 키워드로 정의되거나
 *	-추상 메서드(abstract로 정의된 메서드)를 하나 이상 가지고 있는 클래스
 *		-메서드 바디가 없음
 *-인터페이스
 *	-interface로 정의
 *	-모든 필드는 public static final
 *	-모든 메서드는 public abstract
 *일반 클래스				추상클래스									인터페이스
 *class A {			abstract class A{							interface A {
 *	int m;				int m;											public static final int m;//전역상수
 *	void abc(){}		abstract void abc() //메서드 중에 하나라도			public abstract void abc();
 *								추상메서드가 있으면 추상클래스임.					
 *
 *
 *																		public String aa() {
 *																			~~~~	
 *																		}디폴트메소드, 예외, 얘도 퍼블릭
 *								class에 abtract없어도					}
 *		}						뒤에ㅔ{}없음ㅁ
 *....				}												
 *					필요한거만 구현										모두 구현해줘야함
 *}																	
 *
 *자바의 접근 제한자
 *-public : 동일 패키지 모든 클래스 + 다른 패키지의 모든 클래스
 *-protected : 동일 패키지 모든 클래스 + 다른 패키지의 자식 클래스(상속 받은 클래스)
 *-default(아무것도 없을때) : 동일 패키지의 모든 클래스
 *-private : 동일 클래스에서만 접근 가능
 *
 *클래스의 외부 구성요소
 *-package - > 디렉토리 정보
 *-import - > 외부 라이브러리, 클래스 파일 임포트
 *-클래스(클래스파일안에 여러개 클래스 선언가능)
 *클래스의 내부 구성요소
 *-프로퍼티
 *-메서드
 *-생성자
 *-내부 클래스(클래스 내부에 또 클래스를 정의할 수 있음)
 *
 *
 *
 *
 *
 */
