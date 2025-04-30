package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //생성자를 private으로 선언해서 외부에서 new 키워드로 생성 못하게 막음
    private SingletonService() {}

    public static void main(String[] args) {
        SingletonService singletonService = new SingletonService();
    }

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
