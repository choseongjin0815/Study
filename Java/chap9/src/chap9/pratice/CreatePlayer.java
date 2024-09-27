package chap9.pratice;

public class CreatePlayer {
    public static void main(String[] args) {
        Player bg = new Beginner();
        bg.go(1);
        Player ad = new Advanced();
        ad.go(2);
        Player sp = new Super();
        sp.go(3);
    }
}
