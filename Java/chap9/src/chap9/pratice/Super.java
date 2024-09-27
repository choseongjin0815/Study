package chap9.pratice;

public class Super extends Player{

    public Super() {
        System.out.println("****고급자 레벨입니다****");
    }

    public void jump(){
        System.out.println("높이 점프한다.");
    }
    public void run(){
        System.out.println("엄청 빨리 달린다.");
    }
    public void  turn(){
        System.out.println("한 바퀴 돈다.");
    }
}
