package chap9.pratice;
/*
일반 클래스 : new를 통한 인스턴스 생성이 가능하고 선언된 메소드들의 바디를 전부 정의 해줘야함
추상 클래스 : 메소드의 바디가 정의 되어 있지 않은 추상 메소드와 바디 부분이 정의되어 있는 일반 메소드 모두 선언 가능
            추상 클래스 자체로는 new를 통한 인스터스 생성이 불가능하고 추상 클래스를 상속받은 자식 클래스에서 부모 클래스의 추상 메소드를 오버라이딩 하여 바디를 정의 해줘야만
            해당 자식 클래스에서 new를 통한 인스턴스 생성이 가능
            추상 클래스란 추상 메소드 유무와 상관없이 클래스 옆에 abstract 키워드가 붙어있으면 추상 클래스이고
            추상 메소드가 있는 경우에는 추상 클래스로서 클래스가 정의되는 것이 강제된다.
            추상 클래스를 상속 받은 자식 클래스에서 부모의 추상 메소드를 일부분만 오버라이딩 하는 경우 해당 클래스 역시 추상 클래스가 되며
            해당 클래스 관계에서 선언된 모든 추상 메소드를 오버라이딩 하여 바디 부분을 정의해주지 않는 이상 new를 통한 사용은 불가능하다.
======== 클래스는 다중 상속이 불가능  ========
인터페이스 : implements를 통한 다중 상속이 가능하고 필드의 경우에는 public static final로 선언한다.
           또한 인터페이스의 메소드는 모두 바디가 정의되어 있으면 안되었지만 자바8부터 디폴트 메소드의 추가로 바디를 정의하여 사용할 수 있음

final 필드 : 값의 변경이 안됨
final 메소드 : 메소드의 오버라이딩, 오버로딩 불가
fianl 클래스 : 클래스의 상속 불가





*/


public abstract class Player {
    public abstract void run();
    public abstract void jump();
    public abstract void turn();
    
    private Player level;
    
    public void upgradeLevel(Player level) {
    	this.level = level;
    }
    
    final void go(int count) {
        run();
        for(int i = 0; i < count; i++) {
            jump();
        }
        turn();
    }
}
